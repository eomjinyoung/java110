/* 서블릿 만들기 
 * - javax.servlet.Servlet 인터페이스 구현
 * 
 */
package bitcamp.java110.ex01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 서블릿을 만들었으면 서블릿 컨테이너에 등록해야 한다.
// 서블릿을 등록할 때 URL을 지정해야 클라이언트가 호출할 수 있다.
// URL은 "/"로 시작해야 한다.
// 클라이언트는 다음과 같이 요청해야 한다.
// 1) 웹 애플리케이션의 경로를 root(/)로 설정했을 경우,
//
//      http://localhost:8888/ex01/servlet01
//
// 2) 웹 애플리케이션의 경로를 web01로 설정했을 경우,
//
//      http://localhost:8888/web01/ex01/servlet01
//
// 3) 웹 애플리케이션의 경로를 별도로 지정하지 않았을 경우, 
//
//      http://localhost:8888/java110-servlet/ex01/servlet01
//
//    즉 웹 애플리케이션 이름 자리에 프로젝트 이름을 사용한다.
//
// 서블릿을 새로 만든 경우, 
// 서블릿 컨테이너를 다시 시작해야 적용된다.
// 만약 이미 만든 서블릿에 대해 변경했을 경우,
// 10초 이내에 자동으로 로딩된다.
// 
@WebServlet("/ex01/servlet01")
public class Servlet01 implements Servlet {

    ServletConfig config;
    
    public Servlet01() {
        System.out.println("Servlet01() 호출됨.");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 서블릿 객체를 만든 후 생성자 다음으로 호출되기 때문에
        // 이 메서드에서는 서블릿이 작업할 때 사용할 자원을 준비하는 일을 한다.
        // 예를 들면, DB 커넥션을 준비한다거나 외부 서버에 소켓을 연결하는 등의 작업이다.
        // 또는 서블릿에서 사용할 서비스 객체나 DAO 객체를 준비하는 일을 한다. 
        System.out.println("init() 호출됨."); 
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        // 서블릿을 실행하다가 서블릿 정보가 필요할 때 
        // 이 메서드를 호출하여 ServletConfig 객체를 리턴 받아 사용한다.
        // 그래서 이 메서드는 init()에서 파라미터로 받은 ServletConfig를 객체를 
        // 잘 보관해 두었다가 호출될 때 리턴해야 한다.
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 클라이언트가 이 서블릿의 실행을 요청할 때마다 서블릿 컨테이너가 호출한다.
        // 그래서 클라이언트가 요청한 일을 수행한다.
        // 예를 들면, 게시물 목록을 출력하거나 로그인을 처리하거나 회원 가입을 처리하는 등의 일을 한다.
        System.out.println("service() 호출됨.");
        
    }

    @Override
    public String getServletInfo() {
        // 서블릿을 실행 중에 직접 호출할 일은 없다.
        // 주로 서블릿 컨테이너의 관리 메뉴에서 서블릿 정보를 출력할 때 
        // 이 메서드의 리턴 값을 받아서 출력한다.
        return "Servlet01";
    }

    @Override
    public void destroy() {
        // 서블릿 객체가 제거되기 직전에 호출되는 메서드이다.
        // 그래서 이 메서드에서는 init()에서 준비한 자원을 해제시키는 일을 한다.
        // 예를 들면, DB 커넥션을 닫는다거나 소켓 연결을 닫는 등의 작업을 수행한다.
        System.out.println("destroy() 호출됨.");
        
    }

}

// 서블릿 구동 절차
// - 클라이언트가 요청한 URL에 응답할 서블릿을 찾는다.
// - 해당 서블릿의 인스턴스가 이미 생성되었다면, 
//      - service()를 호출한다.
// - 해당 서블릿의 인스턴스가 아직 생성되지 않았다면,
//      - 서블릿 객체 생성 및 생성자 호출
//      - init() 호출
//      - service() 호출
// - 만약 서블릿 컨테이너를 종료하거나 웹 애플리케이션의 실행을 멈춘다면,
//      - 생성된 모든 서블릿들에 대해 destroy() 호출
//      - 생성된 모든 서블릿 객체를 가비지로 만든다.
// 
// 주의!
// - 서블릿 객체는 클래스 당 한 개만 생성된다.
// - 요청할 때마다 생성되는 것이 아니다.
// - 클라이언트마다 객체가 생성되는 것이 아니라 한 객체를 사용하는 것이기 때문에,
//   객체의 인스턴스 변수를 공유하게 된다.
// - 클라이언트 마다 구분해서 값을 저장해야 한다면, 
//   서블릿의 인스턴스 변수를 사용해서는 안된다.
//   왜? 서블릿 객체는 한 개만 생성되고 모든 클라이언트가 공유한다.

































