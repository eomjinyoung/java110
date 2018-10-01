// 세션 사용 후 - HttpSession 보관소에 데이터 저장하기
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex11/servlet11")
public class Servlet11 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>1페이지</h1>");
        out.println("<form action='servlet12' method='post'>");
        out.println("이름: <input type='text' name='name'><br>");
        out.println("<button>다음</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}













