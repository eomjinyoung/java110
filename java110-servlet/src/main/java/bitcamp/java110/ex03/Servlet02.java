/* 클라이언트로 출력하기 - 한글 깨짐 현상 해결
 * 
 */
package bitcamp.java110.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex03/servlet02")
public class Servlet02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 출력스트림 객체를 꺼내기 전에 어떤 문자표를 사용하여 출력할 것인지 지정해야 한다.
        // 출력스크림을 꺼내기 전에 지정해야 한다.
        res.setContentType("text/plain;charset=UTF-8");
        // => 서블릿 컨테이너는 
        //    이 설정에 따라 출력할 수 있는 출력스트림 객체를 리턴한다.
        //    또한 응답할 때 Content-Type이라는 응답헤더를 추가한다.
        //    
        // => 웹브라우저는 Content-Type 응답 헤더의 정보에 따라 
        //    웹서버가 보낸 콘텐트를 처리한다.
        
        PrintWriter out = res.getWriter();
        out.println("Hello!");
        out.println("안녕하세요!");
        out.println("こんにちは");
        out.println("你好");
        
        // Content-Type
        // => text/plain    : MIME 타입 지정 
        // => charset=UTF-8 : 출력할 때 사용할 문자표 지정
        // => Content-Type을 지정하지 않으면 기본으로 ISO-8859-1 문자표를 사용한다.
        // => Content-Type을 지정하면 응답할 때 응답헤더에 이 정보를 추가한다.
        // => 웹브라우저는 응답헤더에 포함된 콘텐트 타입의 정보를 바탕으로 
        //    콘텐트를 어떻게 처리할 지 결정한다.
        //    웹브라우저가 처리할 수 없는 MIME 타입인 경우 사용자에게 다운로드를 요구한다.
        // 
        // MIME(Multi-purpose Internet Mail Extensions)
        // => 메일에 첨부하는 파일의 타입을 지정하기 위해 만들었다.
        // => 메일 클라이언트는 이 타입 정보를 보고 첨부 파일을 읽을 때
        //    어떤 프로그램을 사용해야 하는지 결정한다.
        // => 세월이 흘러 인터넷 분야에서 콘텐트의 타입을 지정할 때 
        //    이 MIME 타입을 사용하게 되었다. 
        // => 웹브라우저는 서버에서 받은 콘텐트를 어떻게 출력할 것인지 
        //    이 MIME 타입을 보고 결정한다.
        // 
        // Character-Set
        // => 컴퓨터에서 문자를 저장할 때 어떤 코드 값으로 저장할 것인지를 정의한 규칙이다.
        // => 예)
        //    ASCII     - 7비트. 미국 표준이다.
        //    ISO-8859  -1(ISO-Latin-1) - 8비트. 국제 표준이다.
        //    EUC-KR    - 16비트. 국제 표준이다. 한글 2350자가 정의되어 있다.
        //    조합형      - 16비트. 아래아한글 규칙. 
        //                초성(5), 중성(5), 종성(5)로 표현.
        //                3만자 이상의 모든 한글 문자를 표기할 수 있다.
        //    MS949(CP949) - 16비트. MS OS의 코드표. 
        //                   EUC-KR(2350) + 8822 = 11172자
        //    Unicode    - 16비트. 국제 표준이다.
        //                 한글은 11172자가 정의되어 있다.
        //                 영어도 2바이트로 표현된다.
        //    UTF-8      - 1 ~ 4바이트로 문자 표현. 국제 표준이다.
        //                 유니코드의 변형이다.
        //                 한글은 규칙에 따라 3바이트로 표현한다.
        //                 영어는 ISO-8859-1 코드 그대로 1바이트로 표현한다.
        // 
        
        
    }
}

































