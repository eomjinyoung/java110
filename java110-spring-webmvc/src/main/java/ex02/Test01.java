// request handler에서 직접 콘텐트 출력하기
package ex02;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01 {
    
    @RequestMapping("/ex02/test01/m1")
    @ResponseBody
    public String m1() {
        // 리턴 값을 콘텐트로 보낼 때 메서드 선언부에 @ResponseBody를 붙인다.
        // 기본 콘텐트 타입이 "text/plain;charset=ISO-8859-1" 이다.
        // 그래서 한글을 출력할 때 ISO-8859-1 문자표에 한글이 정의되지 않아서 
        // ?로 바뀌어 출력된다.
        return "Hello! 안녕하세요!";
    }
    
    @RequestMapping(value="/ex02/test01/m2", 
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2() {
        // 한글이 깨지지 않도록 하려면 @RequestMapping에 정보를 등록하라!
        //
        return "Hello! 안녕하세요!";
    }
    
    @RequestMapping("/ex02/test01/m3")
    public HttpEntity<String> m3() {
        // 
        // 리턴 타입이 HttpEntity일 경우 
        // 프론트 컨트롤러는 리턴 값이 콘텐트인 것으로 간주한다.
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        HttpEntity<String> entity = new HttpEntity<>(
                "Hello! 안녕하세요!",
                headers);
        
        return entity;
    }
    
    @RequestMapping("/ex02/test01/m4")
    public ResponseEntity<String> m4() {
        // 
        // 리턴 타입이 ReponseEntity일 경우 
        // 프론트 컨트롤러는 리턴 값이 콘텐트인 것으로 간주한다.
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        ResponseEntity<String> entity = new ResponseEntity<>(
                "Hello! 안녕하세요!",
                headers,
                HttpStatus.OK);
        
        return entity;
    }
    
    
}









