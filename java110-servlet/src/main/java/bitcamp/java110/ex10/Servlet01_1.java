/* 쿠키(cookie)  
 * => 클라이언트에 보관하는 데이터이다.
 * => 문자열만 보관할 수 있다.
 *    다른 타입의 데이터를 보관하려면 문자열로 변환한 다음에 보관해야 한다.
 * => 서버로부터 쿠키를 받은 웹브라우저는 
 *    다음에 같은 경로에 소속된 서블릿을 요청할 때
 *    그 쿠키를 다시 서버에 제시한다.  
 * => 같은 경로?
 *    예) /a/s1 을 실행할 때 쿠키를 받았다면
 *       다음에 /a/** 경로로 시작하는 요청에 대해서는 
 *       /a/s1 에서 받은 쿠키를 서버에 제시해야 한다. 
 *       
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

@WebServlet("/ex10/servlet01_1")
public class Servlet01_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {

        // 1) 쿠키 만들기
        Cookie c1 = new Cookie("name", "hongkildong");
        Cookie c2 = new Cookie("age", "12");
        Cookie c3 = new Cookie("working", "true");
            
        // 2) 응답 헤더에 쿠키를 포함하기
        res.addCookie(c1);
        res.addCookie(c2);
        res.addCookie(c3);
        /* HTTP 응답 프로토콜 예)
HTTP/1.1 200
Set-Cookie: name=hongkildong     <=== 클라이언트로 쿠키를 보내는 방법
Set-Cookie: age=12
Set-Cookie: working=true
Content-Type: text/html;charset=UTF-8
Content-Length: 130
Date: Mon, 01 Oct 2018 02:49:43 GMT         
         */
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex10</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>쿠키 보내기</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
































