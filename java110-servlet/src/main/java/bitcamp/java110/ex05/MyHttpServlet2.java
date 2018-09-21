package bitcamp.java110.ex05;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class MyHttpServlet2 extends GenericServlet {

    @Override
    public void service(
            ServletRequest req, 
            ServletResponse res) 
                    throws ServletException, IOException {
        // 여기에서 ServletRequest와 ServletResponse를 
        // HttpServletRequest와 HttpServletResponse로 타입 캐스팅 한다.
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        
        this.service(httpReq, httpRes);
    }
    
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        String method = request.getMethod();
        
        if (method.equals("GET")) {
            doGet(request, response);
        } else if (method.equals("POST")) {
            doPost(request, response);
        } else {
            throw new ServletException("지원하지 않는 요청 방식입니다.");
        }
    }

    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        // 만약 서브 클래스에서 이 메서드를 오버라이딩 하지 않는다면,
        // 다음과 같이 예외가 발생할 것이다.
        throw new ServletException("POST 요청을 지원하지 않습니다.");
        
    }

    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        // 만약 서브 클래스에서 이 메서드를 오버라이딩 하지 않는다면,
        // 다음과 같이 예외가 발생할 것이다.
        throw new ServletException("GET 요청을 지원하지 않습니다.");
        
    }

}














