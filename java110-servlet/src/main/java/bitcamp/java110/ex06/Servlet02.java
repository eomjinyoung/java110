/* 서블릿 배치 정보 - 초기 파라미터
 * => 서블릿이 실행하는 동안 사용할 값이 고정값이라면
 *    자바 코드로 그 값을 표현하기 보다는 
 *    애노테이션이나 XML 태그로 표현하는 것이 관리하기 편하다. 
 */
package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( // 배치 정보를 설정하는 애노테이션
        value="/ex06/servlet02",
        initParams= {
            @WebInitParam(name="aaa",value="hello"),
            @WebInitParam(name="bbb",value="hello2"),
            @WebInitParam(name="ccc",value="hello3")
        })
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {

        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        // 배치 정보에서 초기화 파라미터 값을 꺼내기
        out.printf("aaa=%s\n", this.getInitParameter("aaa"));
        out.printf("bbb=%s\n", this.getInitParameter("bbb"));
        out.printf("ccc=%s\n", this.getInitParameter("ccc"));
    }
}





























