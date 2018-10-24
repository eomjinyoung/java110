// 쿠키 값 받기
package ex02;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test19")
public class Test19 {
    
    @RequestMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpServletResponse response) throws Exception {
        
        response.addCookie(new Cookie("name", 
                // 쿠키에 ASCII 코드가 아닌 문자가 포함될 경우 보낼 수 없다.
                // URL 인코딩하여 보내라!
                URLEncoder.encode("hongkildong,홍길동", "UTF-8")));
        response.addCookie(new Cookie("age", "20"));
        
        return "쿠키 보냈음!";
    }
    
    @RequestMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            // 해당 이름의 쿠키가 없으면 예외가 발생한다.
            @CookieValue("name") String name,
            @CookieValue("age") int age) {
        
        return String.format("name=%s, age=%s\n", 
                name, age);
    }
    
    @RequestMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(
            // 기본 값을 지정해 놓으면 해당 쿠키가 없더라도 오류가 발생하지 않는다.
            @CookieValue(value="name", defaultValue="") String name,
            @CookieValue(value="age", defaultValue="0") int age) {
        
        return String.format("name=%s, age=%s\n", 
                name, age);
    }
    
}









