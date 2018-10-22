package bitcamp.java110.cms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 요청한 URL에서 /app 다음에 지정한 경로를 추출한다.
        String pageControllerPath = request.getPathInfo();
        
        // 페이지 컨트롤러 실행 
        RequestDispatcher rd = request.getRequestDispatcher(
                                            pageControllerPath);
        rd.include(request, response);
        
        // 페이지 컨트롤러의 리턴 값 추출
        String viewUrl = (String)request.getAttribute("viewUrl");
        
        // 페이지 컨트롤러가 지정한 URL을 실행
        response.setContentType("text/html;charset=UTF-8");
        rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
    }
}














