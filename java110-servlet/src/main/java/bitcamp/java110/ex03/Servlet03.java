/* 클라이언트로 출력하기 - HTML 출력
 * 
 */
package bitcamp.java110.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex03/servlet03")
public class Servlet03 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 만약 MIME 타입을 text/plain으로 지정한다면,
        // 출력은 텍스트 그대로 출력될 것이다.
        // HTML로서 출력하고 싶다면,
        // MIME 타입을 다음과 같이 text/html로 지정하라!
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Welcome!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>환영합니다!</h1>");
        out.println("</body>");
        out.println("</html>");
        
    }
}

































