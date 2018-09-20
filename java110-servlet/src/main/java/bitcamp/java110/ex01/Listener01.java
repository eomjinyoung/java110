// 리스너 만들기 
// - 리스너(listener)? 특정 상황에 놓이면 실행되는 객체이다.
// - javax.servlet.XxxListener
//
package bitcamp.java110.ex01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 웹애플리케이션이 시작되거나 종료되는 상황일 때 실행되는 리스너 만들기
// 리스너를 만들었으면 서블릿 컨테이너에 등록해야 한다.
//@WebListener
public class Listener01 implements ServletContextListener {
    
    public Listener01() {
        System.out.println("Listener01() 호출됨.");
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 웹 애플리케이션이 시작될 때 이 메서드가 호출된다.
        // 이 웹 애플리케이션에 소속된 서블릿들이 
        // 공통으로 사용하는 자원은 이 메서드에서 준비한다.
        // 예를 들면, IoC 컨테이너, DAO, DB 커넥션 등
        System.out.println("Listener01.contextInitialized()");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 웹 애플리케이션이 종료될 때 이 메서드가 호출된다.
        // contextInitialized()에서 준비했던 자원을 해제시킨다.
        System.out.println("Listener01.contextDestroyed()");
    }
}








