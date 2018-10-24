// @RequestMapping 다루기 : HTTP 요청 파라미터로 메서드 구분하기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test04 {
    
    // 특정 이름을 갖는 파라미터를 포함하고 있을 때만 호출되도록 한다.
    // 테스트:
    // http://localhost:8888/app/ex02/test04?name=aaa
    // http://localhost:8888/app/ex02/test04?name=aaa&age=20
    // http://localhost:8888/app/ex02/test04?age=20
    @RequestMapping(value="/ex02/test04", 
            params="name")
    @ResponseBody
    public String m1() {
        return "ex02.Test04.m1()";
    }
    
    @RequestMapping(value="/ex02/test04", 
            params="age")
    @ResponseBody
    public String m2() {
        return "ex02.Test04.m2()";
    }
    
    @RequestMapping(value="/ex02/test04", 
            params={"age","name"})
    @ResponseBody
    public String m3() {
        return "ex02.Test04.m3()";
    }
    
    @RequestMapping(value="/ex02/test04")
    @ResponseBody
    public String m4() {
        return "ex02.Test04.m4()";
    }
    
}









