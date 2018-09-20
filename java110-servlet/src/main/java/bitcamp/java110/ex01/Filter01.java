// 필터 만들기
// - javax.servlet.Filter 인터페이스 구현
//
package bitcamp.java110.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 필터를 만들었으면 어떤 요청에 대해 실행할 것인지 등록해야 한다.
// URL은 반드시 "/"로 시작해야 한다.
//@WebFilter({"/ex01/*","/ex02/*"})
public class Filter01 implements Filter {

    public Filter01() {
        System.out.println("Filter01() 호출됨.");
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터가 생성된 후 생성자 호출 후 이 메서드가 실행된다.
        // 필터가 작업하는 동안 사용할 자원을 준비하는 일을 한다.
        System.out.println("Filter01.init() 호출됨.");
    }
    
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        // 클라이언트가 요청한 서블릿을 실행하기 전에 
        // 해당 URL에 등록한 필터를 실행한다.
        // 이때 이 메서드가 호출된다.
        // 서블릿을 실행하기 전,후에 수행해야 할 작업이 있다면 이 메서드에서 실행한다.
        // 
        // 서블릿을 실행하기 전에 하는 일:
        // - 클라이언트가 암호화해서 보낸 데이터를 서블릿이 사용할 수 있도록 암호 해제하기
        // - 클라이언트가 압축해서 보낸 데이터를 서블릿이 사용할 수 있도록 압축해제 하기
        // - 클라이언트의 요청에 대해 기록을 남기기 
        // - 클라이언트가 특별한 형식으로 보낸 데이터를 파싱하여 서블릿이 사용하기 쉽게 변환하기
        // - 클라이언트가 요청한 서블릿의 실행 권한이 있는지 검사하기
        // - 클라이언트가 로그인 한 사용자인지 검사하기
        //
        System.out.println("Filter01.doFilter() --- before");
        
        // => 다음 필터가 있다면 실행하고 없다면 서블릿을 호출하게 한다.
        chain.doFilter(request, response);
        // 위 메서드를 호출하지 않으면 다음 필터나 서블릿을 실행하지 않는다.
        // 따라서 빼면 안된다.
        // 최종적으로 서블릿의 service() 호출이 끝나면 위 메서드는 리턴된다.
        
        // 서블릿을 실행한 후에 하는 일:
        // - 클라이언트로 보낼 데이터를 압축하기
        // - 클라이언트로 보낼 데이터를 암호화하기
        // - 클라이언트로 보낼 데이터를 특정 형식으로 변환하기
        System.out.println("Filter01.doFilter() -- after");
        
        
        
    }
    
    @Override
    public void destroy() {
        // 톰캣 서버가 종료되거나 웹 애플리케이션이 멈출 때 
        // 생성된 모든 필터에 대해 이 메서드를 호출한다.
        // init()에서 준비했던 자원을 해제시키는 일을 한다.
        System.out.println("Filter01.destory() 호출됨");
    }

}


// 필터가 구동되는 절차
// - 톰캣 서버를 시작하거나 웹 애플리케이션을 시작하면 필터 객체를 생성한다.
//   - 생성자 호출 => init() 호출
// - 클라이언트 요청이 들어오면,
//   - 필터에 해당하는 URL이면, doFilter() 호출
//   - 필터에 해당하지 않는 URL이면 이 필터는 동작되지 않는다.
// - 톰캣 서버를 종료하거나 웹 애플리케이션을 멈추면,
//   - destroy() 호출
//
// 주의!
// - 필터는 호출 순서를 명확하게 제어할 수 없다.
// - 따라서 필터 순서에 의존하는 방식으로 프로그래밍을 해서는 안된다.
// 

























