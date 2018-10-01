/* 쿠키(cookie) - 같은 경로의 서블릿이 쿠키를 받는 예 
 */
package bitcamp.java110.ex10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex1xx/servlet04")
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex10</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>쿠키 받기3</h1>");
        
        // 경로가 다르면 웹브라우저는 서버에 쿠키를 보내지 않는다.
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.printf("<p>%s=%s</p>\n", 
                        cookie.getName(), 
                        cookie.getValue());
            }
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}
































