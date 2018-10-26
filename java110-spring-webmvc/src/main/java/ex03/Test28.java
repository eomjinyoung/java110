// 세션 다루기 - @ModelAttribute 애노테이션
package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ex03/test28")
@SessionAttributes({"name2","gender2"})
public class Test28 {
    
    // 테스트:
    //      http://localhost:8888/app/ex03/test28/m1
    //
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(Model model, HttpSession session) throws Exception {
        model.addAttribute("name2", "임꺽순"); // 프론트 컨트롤러가 세션에 보관
        model.addAttribute("tel2", "1111-222");
        model.addAttribute("gender2", "여자"); // 프론트 컨트롤러가 세션에 보관
        
        session.setAttribute("age2", "20"); // 페이지 컨트롤러가 직접 세션에 보관
        
        return "ex03.Test28.m1()";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            // @SessionAttributes에 지정된 값을 받고 싶을 때 
            // 파라미터 변수에 @ModelAttribute 애노테이션을 붙여라. 
            // => 이름을 명시해야 한다.
            // => session 객체에 직접 저장한 값은 받지 못한다.
            // => 값을 없으면 null이 아니라 빈 문자열 넣어 준다.
            //
            @ModelAttribute("name2") String name2,
            @ModelAttribute("tel2") String tel2,
            @ModelAttribute("gender2") String gender2,
            @ModelAttribute("age2") String age2
            ) throws Exception {
        
         
        
        return String.format("%s,%s,%s,%s\n", 
                name2, tel2, gender2, age2);
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(HttpSession session) throws Exception {
        
        session.invalidate();
        return String.format("세션을 무효화시켰다!\n");
    }
    
    @GetMapping(value="m4", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m4(HttpSession session) throws Exception {
        
        String name2 = (String) session.getAttribute("name2");
        String tel2 = (String) session.getAttribute("tel2");
        String gender2 = (String) session.getAttribute("gender2");
        String age2 = (String) session.getAttribute("age2");
        
        return String.format("%s,%s,%s,%s\n", 
                name2, tel2, gender2, age2);
    }
    
    
    @GetMapping(value="m5", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m5(
            // 다른 페이지 컨트롤러의 @SessionAttributes에서
            // 지정한 값을 받을 때? 
            // => 안된다. 현재 페이지 컨트롤러에서 지정한 이름의 값만 받을 수 있다.
            @ModelAttribute("name") String name,
            @ModelAttribute("tel") String tel,
            @ModelAttribute("gender") String gender
            ) throws Exception {
        
        
        
        return String.format("%s,%s,%s\n", 
                name, tel, gender);
    }
    
    @GetMapping(value="m6", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m6(HttpSession session) throws Exception {
        // 다른 페이지 컨트롤러의 @SessionAttributes에서 
        // 지정한 값을 HttpSession 객체에서 직접 꺼낼 때?
        // => 꺼낼 수 있다.
        String name = (String) session.getAttribute("name");
        String tel = (String) session.getAttribute("tel");
        String gender = (String) session.getAttribute("gender");
        
        return String.format("%s,%s,%s\n", 
                name, tel, gender);
    }
    
}








