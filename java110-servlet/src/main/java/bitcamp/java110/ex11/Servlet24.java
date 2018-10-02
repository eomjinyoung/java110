// 세션 - 세션을 강제로 무효화시키기
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet24")
public class Servlet24 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // 현재 세션을 강제로 무효화시킨다. 
        session.invalidate();
        
        // 테스트:
        // 1) 세션 생성 - /ex11/servlet21 실행
        // 2) 세션 값 조회 - /ex11/servlet22 실행
        // 3) 세션 무효화 - /ex11/servlet24 실행
        // 4) 세션 값 조회 - /ex11/servlet22 실행
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>세션을 무효화시키기</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}













