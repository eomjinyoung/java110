package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.mvc.RequestMappingHandlerMapping;
import bitcamp.java110.cms.mvc.RequestMappingHandlerMapping.Handler;
import bitcamp.java110.cms.mvc.RequestParam;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 요청한 URL에서 /app 다음에 지정한 경로를 추출한다.
        String pageControllerPath = request.getPathInfo();
        
        // 스프링 IoC 컨테이너 가져오기
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext()
                                        .getAttribute("iocContainer");
        
        try {
            // IoC 컨테이너에서 요청 URL을 처리할 메서드를 찾아야 한다.
            // 1) 메서드 정보가 보관된 객체를 얻는다.
            RequestMappingHandlerMapping handlerMapping = 
                (RequestMappingHandlerMapping) iocContainer.getBean(
                        RequestMappingHandlerMapping.class);
            
            // 2) HandlerMapping에서 url을 처리할 메서드 정보를 얻는다.
            Handler handler = handlerMapping.getHandler(pageControllerPath);
            
            if (handler == null)
                throw new Exception("요청을 처리할 수 없습니다!");
            
            // 페이지 컨트롤러가 작업한 결과를 담을 저장소를 준비한다.
            HashMap<String,Object> resultMap = new HashMap<>();
            
            // 3) URL을 처리할 메서드를 호출한다.
            // => 메서드에 넘겨줄 파라미터 값을 준비한다.
            Object[] paramValues = prepareParamValues(
                    handler.method,
                    request, 
                    response,
                    resultMap);
            
            // => 메서드를 호출한다.
            String viewUrl = (String)handler.method.invoke(
                                handler.instance, 
                                paramValues);
            
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
                
            } else {
                // JSP를 실행하기 전에 페이지 컨트롤러가 작업한 결과물을 
                // ServletRequest 보관소로 옮긴다.
                Set<Entry<String,Object>> entrySet = resultMap.entrySet();
                for (Entry<String,Object> entry : entrySet) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                
                // 페이지 컨트롤러가 지정한 URL을 실행
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher rd = 
                        request.getRequestDispatcher(viewUrl);
                rd.include(request, response);
            }
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "실행 오류!");

            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.include(request, response);
        }
    }

    private Object[] prepareParamValues(
            Method method, 
            HttpServletRequest request, 
            HttpServletResponse response,
            Map<String,Object> resultMap) {

        // 파라미터의 값을 저장할 리스트 준비
        ArrayList<Object> paramValues = new ArrayList<>();
                
        // 메서드의 파라미터 정보 가져오기
        Parameter[] params = method.getParameters();
        
        for (Parameter p : params) {
            if (p.getType() == HttpServletRequest.class) {
                paramValues.add(request);
            } else if (p.getType() == HttpServletResponse.class) {
                paramValues.add(response);
            } else if (p.getType() == HttpSession.class) {
                paramValues.add(request.getSession());
            } else if (p.getType() == Map.class) {
                paramValues.add(resultMap);
            } else if (p.getType() == byte.class ||
                       p.getType() == short.class ||
                       p.getType() == int.class ||
                       p.getType() == long.class ||
                       p.getType() == float.class ||
                       p.getType() == double.class ||
                       p.getType() == boolean.class ||
                       p.getType() == char.class ||
                       p.getType() == String.class) {
                
                paramValues.add(getRequestParamValue(p, request));
                
            } else {
                paramValues.add(getObjectValue(p, request));
            }
        }
        
        return paramValues.toArray();
    }

    private Object getObjectValue(Parameter p, HttpServletRequest request) {
        try {
            // 파라미터의 타입을 알아낸다.
            Class<?> clazz = p.getType();
            
            // 클라이언트가 보낸 값을 담을 수 있도록 해당 타입의 객체를 만든다.
            // => 기본 생성자를 알아낸다.
            Constructor<?> c = clazz.getConstructor();
            // => 생성자를 통해 객체를 생성한다.
            Object obj = c.newInstance();
            
            // 해당 타입의 setter를 알아낸다.
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                if (!m.getName().startsWith("set")) continue;
                
                // 메서드 이름에서 프로퍼티명을 추출한다.
                // => set/get 이름을 제거한다.
                // => 첫 번째 알파벳을 소문자로 한다.
                // => setPageNo()
                String propName = m.getName().substring(3,4).toLowerCase() +
                        m.getName().substring(4);
                String value = request.getParameter(propName);
                
                if (value == null) continue;
                
                // 메서드의 파라미터 타입을 알아낸다.
                Parameter paramType = m.getParameters()[0];
                
                // 파라미터 값을 setter가 원하는 형식으로 변환하여 객체에 저장한다.
                // => setter를 호출하여 저장한다.
                m.invoke(obj, convertValue(value, paramType.getType()));
                
            }
            return obj;
            
        } catch (Exception e) {
            throw new RuntimeException("파라미터 값을 객체에 담을 수 없습니다.");
            
        }
    }

    private Object getRequestParamValue(Parameter p, HttpServletRequest request) {
        // 파라미터의 RequestParam 애노테이션 정보를 추출한다.
        RequestParam anno = p.getAnnotation(RequestParam.class);
        
        String value = request.getParameter(anno.value());
        if (value == null) { // 클라이언트가 보낸 값이 없고
            if (anno.defaultValue().length()== 0) { // 기본 값이 정의되어 있지 않다면,
                return null;
            } else {
                value = anno.defaultValue();
            }
        }
        
        return convertValue(value, p.getType());
    }

    private Object convertValue(String value, Class<?> type) {
        if (type == byte.class)
            return Byte.parseByte(value);
        else if (type == short.class)
            return Short.parseShort(value);
        else if (type == int.class)
            return Integer.parseInt(value);
        else if (type == long.class)
            return Long.parseLong(value);
        else if (type == float.class)
            return Float.parseFloat(value);
        else if (type == double.class)
            return Double.parseDouble(value);
        else if (type == boolean.class)
            return Boolean.parseBoolean(value);
        else if (type == char.class) {
            if (value.length() > 1)
                throw new RuntimeException("String을 char로 변환할 수 없습니다.");
            return value.charAt(0);
        }
        return value;
    }
}














