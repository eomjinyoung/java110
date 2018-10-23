// 페이지 컨트롤러 만들기
//
package ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01 {
    
    @RequestMapping("/ex01/hello")
    @ResponseBody
    public String hello() {
        return "Hello!";
    }
}
