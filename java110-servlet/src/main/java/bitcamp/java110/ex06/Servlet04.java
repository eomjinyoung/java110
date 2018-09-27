/* 서블릿 배치 정보 - XML 태그로 배치 정보 설정하기
 * => loadOnStartup 과 초기화 파라미터를 XML로 설정하기
 */
package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
@WebServlet(
        value="/ex06/servlet04",
        loadOnStartup=1,
        initParams= {
                @WebInitParam(name="aaa",value="hello"),
                @WebInitParam(name="bbb",value="hello2"),
                @WebInitParam(name="ccc",value="hello3")
        })
*/
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet04() {
        System.out.println("ex06.Servlet04...생성자 호출됨!");
    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("ex06.Servlet04.init()...호출됨!");
    }
    
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





























