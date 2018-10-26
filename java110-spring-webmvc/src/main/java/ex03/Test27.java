// 세션 다루기 - @SessionAttributes 애노테이션
package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ex03/test27")

// request handler가 Model 이나 Map 객체에 저장하는 값 중에서 
// 세션에도 저장할 값을 지정할 때 다음 애노테이션을 사용한다.
@SessionAttributes({"name","gender"})
public class Test27 {
     
    // 테스트:
    //      http://localhost:8888/app/ex03/test27/m1
    //
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(Model model) throws Exception {
        model.addAttribute("name", "홍길동");
        model.addAttribute("tel", "1111-1111");
        model.addAttribute("gender", "남자");
        
        return "ex03.Test27.m1()";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) throws Exception {
        
        String name = (String) session.getAttribute("name");
        String tel = (String) session.getAttribute("tel");
        String gender = (String) session.getAttribute("gender");
        
        return String.format("%s,%s,%s\n", name, tel, gender);
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(HttpSession session) throws Exception {
        
        session.invalidate();
        return String.format("세션을 무효화시켰다!\n");
    }
    
}








