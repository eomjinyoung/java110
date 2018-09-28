/* 포워드(forward)  
 * => 다른 서블릿으로 작업을 위임하는 기술
 *    이전 서블릿에서 출력한 내용이 있다면 포워드 전에 버린다.
 *    그래서 작업을 위임 받은 서블릿에서 새로 출력한다.  
 */
package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {
        
        String op = req.getParameter("op");
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex09</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>더하기 계산 결과</h1>");
        
        if (!op.equals("+")) {
            // 빼기 연산을 수행하는 서블릿으로 작업을 위임한다.
            // 주의!
            // => 현재까지 출력한 내용을 버린다.
            // 
            // 어떻게 웹브라우저로 출력한 것을 취소할 수 있는가?
            // => 아직 클라이언트로 출력하지 않았기 때문에 가능하다.
            // => out.println() 과 같은 출력문을 호출하면 
            //    즉시 클라이언트로 출력하는 것이 아니라 버퍼로 출력한다.
            //
            
            // 포워딩을 수행할 작업자를 준비한다.
            RequestDispatcher 요청배달자 = 
                    req.getRequestDispatcher("servlet02");
            
            // 작업을 위임 받은 서블릿이 데이터를 바로 사용할 수 있도록 
            // ServletRequest 보관소에 저장한다.
            req.setAttribute("op", op);
            req.setAttribute("a", a);
            req.setAttribute("b", b);
            
            요청배달자.forward(req, res);
            return;
        }
        out.printf("<p>%d + %d = %d</p>\n", a, b, (a + b));
        out.println("</body>");
        out.println("</html>");
    }
}


// 주의!
// => '+' 문자를 서버에 보낼 때 주의해야 한다.
// => URL에서 '+' 문자는 공백을 의미한다.
//    따라서 서버에서 값을 꺼내면(getParameter() 호출) 공백이 리턴된다.
// => '+' 문자를 서버에 보내려면 URL 인코딩 값을 보내야 한다.
//    즉 '%2B'를 보내야 한다.
// => 따라서 + 연산을 이 서블릿에 보내려면 다음과 같이 URL을 작성해야 한다.
//    http://localhost:8888/ex09/servlet01?a=100&b=80&op=%2B
//




































