package bitcamp.java110.ex07;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
public class Listener01 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 웹애플리케이션이 시작될 때 호출된다.
        System.out.println("ex07.Listener01.contextInitialized() 호출됨!");
        
        // ServletContext 보관소를 알아낸다.
        ServletContext sc = sce.getServletContext();
        
        // ServletContext 보관소에 값을 보관한다.
        sc.setAttribute("aaa", "홍길동");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 웹애플리케이션이 종료될 때 호출된다.
        System.out.println("ex07.Listener01.contextDestroyed() 호출됨!");
    }
}








