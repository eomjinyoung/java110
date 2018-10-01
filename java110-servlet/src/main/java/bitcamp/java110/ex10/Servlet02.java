/* 쿠키(cookie) - 웹브라우저가 보낸 쿠키 꺼내기  
 * => 클라이언트에 보관하는 데이터이다.
 * => 문자열만 보관할 수 있다.
 *    다른 타입의 데이터를 보관하려면 문자열로 변환한 다음에 보관해야 한다.
 * => 서버로부터 쿠키를 받은 웹브라우저는 
 *    다음에 서버에 요청할 때 그 쿠키를 다시 서버에 제시해야 한다.  
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

@WebServlet("/ex10/servlet02")
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {

        // 1) HTTP 요청 프로토콜에서 쿠키 목록을 가져온다.
        // => 쿠키가 없다면 null을 리턴한다.
        /* HTTP 요청 프로토콜 예)
GET /ex10/servlet02 HTTP/1.1
Host: localhost:8888
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,..
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
Cookie: name=hongkildong; age=12; working=true  <==== 서버에 보내는 쿠키         
         
         */
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
        out.println("<h1>쿠키 받기</h1>");
        
        // 2) 웹브라우저가 쿠키를 보내왔으면 꺼내 출력한다.
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
































