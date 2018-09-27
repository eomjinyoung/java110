/* 서블릿 배치 정보 - XML 태그로 배치 정보 설정하기
 * => 서블릿의 배치 정보를 설정하는데는 두 가지 방법이 있다.
 *    1) 애노테이션으로 배치하기
 *       @WebServlet 애노테이션을 서블릿 클래스에 선언한다.
 *    2) XML 태그로 배치하기
 *       /WEB-INF/web.xml에 서블릿 배치 정보를 설정한다.
 *       'web.xml'을 '배치설명자'(Deployment Descriptor 파일; DD 파일)라 부른다.
 *       
 * => 주의!
 *    web.xml 파일을 사용하여 서블릿을 배치할 때 
 *    'metadata-complete' 속성 값을 false로 설정하지 않으면 
 *    애노테이션으로 배치한 정보를 인식하지 못한다.
 <web-app 
       ...
       metadata-complete="false">
       
     ...
     
 </web-app>
 */
package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ex06/servlet03")
public class Servlet03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {

        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex06/servlet03 실행!");
    }
}





























