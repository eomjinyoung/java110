// 인터셉터 정의하기
package ex03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor2 implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Interceptor2.preHandler()...");
        if (request.getParameter("name") != null) {
            response.sendRedirect("../m1");
            
            // 리턴 값이 false이면 페이지 컨트롤러를 실행하지 않는다.
            return false; 
        }
        
        // 리턴 값이 true이면 다음 인터셉터나 페이지 컨트롤러를 실행한다.
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor2.postHandle()...");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Interceptor2.afterCompletion()...");
    }
    
    
}

























