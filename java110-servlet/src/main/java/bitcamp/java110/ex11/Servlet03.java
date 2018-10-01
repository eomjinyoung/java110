// 세션 사용 전 - hidden 타입 input 필드 사용
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex11/servlet03")
public class Servlet03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>non-session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>3페이지</h1>");
        out.println("<form action='servlet04' method='post'>");
        out.printf("<input type='hidden' name='name' value='%s'>\n", name);
        out.printf("<input type='hidden' name='age' value='%s'>\n", age);
        out.println("전화: <input type='tel' name='tel'><br>");
        out.println("<button>다음</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}













