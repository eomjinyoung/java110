// @GetMapping, @PostMapping
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test17")
public class Test17 {
    
    // 테스트:
    //      http://localhost:8888/ex02/Test17.html
    
    //@RequestMapping(value="m1", method=RequestMethod.GET)
    //위의 애노테이션 대신 다음 애노테이션을 사용해도 된다.
    @GetMapping("m1")
    @ResponseBody
    public String m1_1() {
        return "ex02.Test17.m1_1()";
    }
    
    //@RequestMapping(value="m1", method=RequestMethod.POST)
    @PostMapping("m1")
    @ResponseBody
    public String m1_2() {
        return "ex02.Test17.m1_2()";
    }
    
}









