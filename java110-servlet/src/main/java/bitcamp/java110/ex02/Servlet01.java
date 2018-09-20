/* 서블릿 만들기 I
 * - javax.servlet.Servlet 인터페이스 구현
 * 
 */
package bitcamp.java110.ex02;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex02/servlet01")
public class Servlet01 implements Servlet {

    ServletConfig config;
    
    public Servlet01() {
        System.out.println("Servlet01() 호출됨.");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init() 호출됨."); 
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service() 호출됨.");
        
    }

    @Override
    public String getServletInfo() {
        return "Servlet01";
    }

    @Override
    public void destroy() {
        System.out.println("destroy() 호출됨.");
        
    }

}

































