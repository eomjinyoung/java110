package bitcamp.java110.ex13;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener01 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // ex13 패키지의 서블릿 객체들이 사용할 Inventory를 준비한다.
        sce.getServletContext().setAttribute("inventory", new Inventory());
        sce.getServletContext().setAttribute("inventory2", new Inventory2());
    }
}
