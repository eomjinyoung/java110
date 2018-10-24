// @RequestMapping 다루기 : URL 다루기 I
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test08 {
    
    // 각 메서드에 URL을 지정하기
    
    @RequestMapping(value="/ex02/test08/m1")
    @ResponseBody
    public String m1() {
        return "ex02.Test08.m1()";
    }
    
    @RequestMapping(value="/ex02/test08/m2")
    @ResponseBody
    public String m2() {
        return "ex02.Test08.m2()";
    }
    
    
}









