// @RequestMapping 다루기 : URL 다루기 II
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test09")
public class Test09 {
    
    // 공통 URL은 클래스에 선언한다.
    
    @RequestMapping("m1")
    @ResponseBody
    public String m1() {
        return "ex02.Test09.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody
    public String m2() {
        return "ex02.Test09.m2()";
    }
    
    
}









