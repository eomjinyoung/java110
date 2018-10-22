package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.mvc.RequestMappingHandlerMapping;
import bitcamp.java110.cms.mvc.RequestMappingHandlerMapping.Handler;

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
            
            // 3) URL을 처리할 메서드를 호출한다.
            // => 메서드에 넘겨줄 파라미터 값을 준비한다.
            Object[] paramValues = prepareParamValues(
                    handler.method,
                    request, 
                    response);
            
            // => 메서드를 호출한다.
            String viewUrl = (String)handler.method.invoke(
                                handler.instance, 
                                paramValues);
            
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
                
            } else {
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
            HttpServletResponse response) {

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
            } else {
                paramValues.add(null);
            }
        }
        
        return paramValues.toArray();
    }
}














