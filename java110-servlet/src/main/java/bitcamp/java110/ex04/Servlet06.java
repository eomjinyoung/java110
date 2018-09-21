/* URL 인코딩
 * 
 */
package bitcamp.java110.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/servlet06")
public class Servlet06 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest req, 
            ServletResponse res) 
            throws ServletException, IOException {
        
        // 테스트:
        // => http://localhost:8888/ex04/servlet06?name=ABC가각
        // 
        // => URL 주소 창에 파라미터 값으로 한글을 입력했다 하더라도
        //    개발 도구 창에서 서버에 요청한 HTTP 프로토콜을 보면 
        //    영어는 그대로 보이지만 한글은 %xx%xx%xx 형식으로 변환되어 
        //    보내지는 것을 확인할 수 있다.
        //    왜?
        
        // 주의! 
        // => GET 요청에서 URL에 한글이 포함될 경우 POST 처럼 따라 설정하지 않아도 된다.
        // => 그런데 톰캣 7 이하에서는 server.xml에 설정을 해 줘야 한글이 깨지지 않는다.
        //    다음과 같이 Connector 태그에 URIEncoding 속성을 추가하라!
        //      <Connector connectionTimeout="20000" 
        //          port="8888" 
        //          protocol="HTTP/1.1" 
        //          redirectPort="8443"
        //          URIEncoding="UTF-8"/>
        //
        
        // 다음은 POST 요청으로 들어온 한글 데이터를 처리할 때 사용하는 것이다.
        // GET 요청에 대해서는 setCharacterEncoding()이 효력이 없다.
        //req.setCharacterEncoding("UTF-8");
        
        String name = req.getParameter("name");
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name=%s\n", name);
    }
}

// URL 인코딩?
// => HTTP 프로토콜로 클라이언트와 서버가 데이터를 주고 받을 때,
//    7비트 장비를 경유하더라도 데이터가 깨지지 않게 하기 위한 방안이다.
// 
// 7비트 장비?
// => 오래전에 구축된 일부 네트워크 장비(Gateway 등)가 7비트인 경우가 있다.
// => 이 경우 8비트 데이터를 전송하면 나올 때 1비트가 손실될 수 있다.
// 
// 해결책?
// => 8비트 값을 ASCII 문자로 바꿔 보내고,
// => 받은 쪽에서는 ASCII 문자를 원래의 바이트로 바꿔 사용한다.
// => 즉 "8비트 데이터를 ASCII 문자화시키는 방법" = "URL 인코딩"
//      "ASCII 문자화된 데이터를 원래의 바이트로 변환하는 것" = "URL 디코딩"
// => 웹브라우저는 데이터를 보내기 전에 URL 인코딩한다.
//    원래 ASCII 문자는 그대로 두고 한글과 같은 7비트를 초과하는 코드인 경우
//    URL 인코딩을 진행한다.
// => 웹서버는 웹브라우저로부터 받은 URL 인코딩 값을 디코딩하여 
//    원래의 바이트 값으로 자동으로 바꾼다.
//    따라서 개발자가 개입할 필요는 없다.
// 
// 그런데 왜 우리가 URL 인코딩/디코딩을 알아야 하나요?
// => 웹브라우저와 웹서버 사이에 데이터를 주고받는 HTTP 프로토콜을 분석하다 보면
//    %xx%xx%xx 와 같은 데이터를 보게 된다. 
//    이런 경우 당황하지 말라고, 왜 그렇게 하는지 정확히 이해하라고 설명한 것이다.
// => 웹브라우저를 통해 서버에 데이터를 보내는 것이 아니라,
//    개발자가 직접 소켓 프로그래밍을 통해 데이터를 보낼 때는 
//    URL 인코딩이 자동으로 처리되는 것이 아니기 때문에 
//    개발자가 java.net.URLEncoder 를 사용하여 직접 URL 인코딩 해야 한다.
// => 웹브라우저가 보낸 데이터를 웹서버를 통해 받지 않고 직접 받는 경우가 있다.
//    이런 경우에도 개발자가 java.net.URLDecoder를 사용하여
//    직접 소켓 프로그래밍으로 URL 디코딩을 해야 한다.
//     
















