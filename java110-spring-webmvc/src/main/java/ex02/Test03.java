// @RequestMapping 다루기 : GET/POST 구분하기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test03 {
    // 테스트 방법
    // /ex02/Test03.html 을 실행하여 테스트 한다.
    
    // GET 요청만 처리하기
    @RequestMapping(value="/ex02/test03/m1", 
            method=RequestMethod.GET,
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1_1() {
        return "GET 요청!";
    }
    
    // POST 요청만 처리하기
    @RequestMapping(value="/ex02/test03/m1", 
            method=RequestMethod.POST,
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1_2() {
        return "POST 요청!";
    }
    
    // GET/POST 모두 처리하기
    // => method를 지정하지 않으면 모든 방식의 요청을 처리할 수 있다.
    @RequestMapping(value="/ex02/test03/m2",
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2() {
        return "모두 처리!";
    }
}









