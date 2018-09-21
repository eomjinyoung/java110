/* GET/POST 구분하기
 * 
 */
package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/ex05/servlet01")
public class Servlet01 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest req, 
            ServletResponse res) 
            throws ServletException, IOException {

        // 테스트:
        // => http://localhost:8888/ex05/test1.html
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();

        // GET/POST/HEAD 등을 구분하는 것은 HTTP 프로토콜의 기능이다.
        // ServletRequest에는 HTTP를 다루는 메서드가 없다.
        // 따라서 원래의 타입인 HttpServletRequest로 변환해야만 가능하다.
        
        HttpServletRequest httpReq = (HttpServletRequest)req;
        String method = httpReq.getMethod();
        
        if (method.equals("GET")) {
            out.println("GET 요청입니다.");
        } else if (method.equals("POST")) {
            out.println("POST 요청입니다.");
        } else {
            out.println("기타 요청입니다.");
        }
    }
}





























