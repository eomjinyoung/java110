// JSP 사용 전 - 로그인 폼 출력하기
// => 개발자가 직접 HTML 출력 코드를 작성해야 한다.
//
// JSP 
// => 개발자를 대신하여 서블릿 클래스를 정의하고,
//    자바 출력 코드를 작성한다.
// => 구동 원리
//    hello.jsp ===> [JSP 엔진] ===> hello_jsp.java 생성
//    - 생성된 자바 클래스는 HttpServlet 클래스의 하위 클래스이다.
//    - 클래스 이름은 JSP 엔진에 따라 다를 수 있다.
//    - JSP 파일을 직접 실행하는 것이 아니다.
//
package bitcamp.java110.ex12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex12/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        // 쿠키 데이터에 email 이 있다면 꺼낸다.
        String email = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) {
                    email = cookie.getValue();
                    break;
                }
            }
        }
        
        if (email == "") { // email 쿠키가 없다면,
            // 다음 요청할 때 이메일 쿠키를 받을 수 있도록 
            // 테스트 용 쿠키를 웹브라우저에게 보낸다.
            Cookie cookie = new Cookie("email", "hongkildong");
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>로그인</title>");
        out.println("<style>");
        out.println("th {");
        out.println("    text-align: right;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>로그인</h1>");
        out.println("<form action='login' method='post'>");
        out.println("<table>");
        out.println("<tr>");
        out.println("    <th></th>");
        out.println("    <td>");
        out.println("        <input type='radio' name='type' value='student' checked>학생"); 
        out.println("        <input type='radio' name='type' value='teacher'>강사");
        out.println("        <input type='radio' name='type' value='manager'>매니저");
        out.println("    </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("    <th>이메일</th>");
        out.printf("    <td><input type='email' name='email' value='%s'></td>\n", email);
        out.println("</tr>");
        out.println("<tr>");
        out.println("    <th>암호</th>");
        out.println("    <td><input type='password' name='password'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("    <th></th>");
        out.println("    <td><input type='checkbox' name='save'>이메일 저장</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("    <th></th>");
        out.println("    <td><button>로그인</button></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}













