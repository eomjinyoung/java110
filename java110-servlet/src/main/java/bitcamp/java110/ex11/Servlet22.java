// 세션의 원리 - 세션ID와 쿠키
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet22")
public class Servlet22 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        // 세션 얻기
        // => /ex11/servlet21을 먼저 실행한 후 이 서블릿을 실행하면,
        //    웹브라우저자 서버에 요청할 때 이전 서블릿에서 받은 세션 아이디를 
        //    요청 프로토콜의 쿠키에 담아서 제출할 것이다.
        //
        // 요청 프로토콜이 세션아이디 쿠키 정보 예)
        /*
GET /ex11/servlet22 HTTP/1.1
...
Cookie: JSESSIONID=6C5ACC0FE85F1EE8679E1A2316368A5C    <=== 세션아이디 제출     
         */
        //
        // 응답 프로토콜의 예)
        // => 웹브라우저가 세션 아이디를 갖고 있기 때문에 다시 세션아이디를 보내지 않는다.
        /*
HTTP/1.1 200
Content-Type: text/html;charset=UTF-8
Content-Length: 162
Date: Tue, 02 Oct 2018 01:03:55 GMT
         */
        HttpSession session = request.getSession();
        
        // 세션에 보관된 데이터 꺼내기
        String name = (String)session.getAttribute("name");
       
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>세션 데이터 꺼내기</h1>");
        out.printf("name=%s<br>\n", name);
        out.println("</body>");
        out.println("</html>");
    }
}













