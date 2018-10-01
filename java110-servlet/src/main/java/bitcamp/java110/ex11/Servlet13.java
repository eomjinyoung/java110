// 세션 사용 후 - HttpSession 보관소에 데이터 저장하기
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet13")
public class Servlet13 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String age = request.getParameter("age");
        
        // 클라이언트가 보낸 데이터를 세션에 보관한다.
        HttpSession session = request.getSession();
        session.setAttribute("age", age);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>3페이지</h1>");
        out.println("<form action='servlet14' method='post'>");
        out.println("전화: <input type='tel' name='tel'><br>");
        out.println("<button>다음</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}













