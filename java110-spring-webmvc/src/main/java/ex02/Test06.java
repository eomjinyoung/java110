// @RequestMapping 다루기 : HTTP accept 헤더로 메서드 구분하기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test06 {
    
    // HTTP 클라이언트는 서버에 요청할 때 자신이 받기를 원하는 콘텐트 형식을 지정한다.
    // => HTTP 요청 헤더에서 "Accept" 헤더의 값으로 MIME 타입을 지정한다.
    // HTTP 서버는 클라이언트의 요청 정보를 분석하여 
    // Accept에 지정된 콘텐트가 있으면 그 콘텐트를 전달한다.
    // 
    // 테스트:
    // http://localhost:8888/ex02/Test06.html
    //
    @RequestMapping(value="/ex02/test06", 
            produces="text/plain")
    @ResponseBody
    public String m1() {
        return "text/plain";
    }
    
    @RequestMapping(value="/ex02/test06", 
            produces="text/html")
    @ResponseBody
    public String m2() {
        return "text/html";
    }
    
    
    @RequestMapping(value="/ex02/test06")
    @ResponseBody
    public String m4() {
        return "etc...";
    }
    

    
}









