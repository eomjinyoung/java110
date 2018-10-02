// 세션 - 타임아웃
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet23")
public class Servlet23 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        // 세션 타임 아웃
        // => 서블릿 컨테이너의 설정 파일에서 세션 타임아웃 시간을 설정할 수 있다.
        //    예) web.xml 파일
        //    <session-config>
        //        <session-timeout>1</session-timeout>
        //    </session-config>    
        // 
        // => 각각의 세션 객체에 대해 타임아웃을 설정할 수 있다.
        //    예) session.setMaxInactiveInterval(초);
        //
        HttpSession session = request.getSession();
        
        // 다음과 같이 세션에 대해 타임아웃을 설정할 수 있다.
        // => 10초 사이에 다시 요청이 들어오지 않으면 
        //    해당 세션은 무효화된다.
        //session.setMaxInactiveInterval(10); // 단위는 초(seconds).
        
        // 세션에 데이터 보관하기
        session.setAttribute("name", "임꺽정");
       
        // 테스트: 
        // => 이 서블릿을 실행한 후 10초 이전에 /ex11/servlet22 실행하기
        // => 그리고 다시 10초가 지난 후에 /ex11/server22 실행하기
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>세션에 데이터 보관하기 - 타임아웃 설정</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}













