// request handler의 파라미터 I
package ex02;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test12")
public class Test12 {
    
    // 프론트 컨트롤러로부터 파라미터 값으로 다음 객체를 받을 수 있다.
    
    @RequestMapping("m1")
    @ResponseBody
    public String m1(ServletRequest req, ServletResponse resp) {
        System.out.println(req);
        System.out.println(resp);
        return "ex02.Test12.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody
    public String m2(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req);
        System.out.println(resp);
        return "ex02.Test12.m2()";
    }
    
    @RequestMapping("m3")
    @ResponseBody
    public String m3(HttpSession session) {
        System.out.println(session);
        return "ex02.Test12.m3()";
    }
    
    // ServletContext는 파라미터로 받을 수 없다.
    @RequestMapping("m4")
    @ResponseBody
    public String m4(ServletContext sc) {
        System.out.println(sc);
        return "ex02.Test12.m4()";
    }
    
    // ServletContext 객체는 다음과 같이 필드로 주입 받아야 한다.
    @Autowired ServletContext sc;
    
    @RequestMapping("m5")
    @ResponseBody
    public String m5() {
        System.out.println(sc);
        return "ex02.Test12.m5()";
    }
    
    // JSP에 넘겨줄 데이터를 담을 수 있는 보관소를 받을 수 있다.
    @RequestMapping("m6")
    public String m6(Map<String,Object> map) {
        
        map.put("name", "홍길동");
        map.put("age", 20);
        
        // Map 객체에 저장한 데이터는 
        // 프론트 컨트롤러가 ServletRequest 보관소로 옮긴다.
        
        return "/ex02/Test12.jsp";
    }
    
    // JSP에 넘겨줄 데이터를 담을 수 있는 보관소를 받을 수 있다.
    @RequestMapping("m7")
    public String m7(Model model) {
        
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        
        // Model 객체에 저장한 데이터는 
        // 프론트 컨트롤러가 ServletRequest 보관소로 옮긴다.
        
        return "/ex02/Test12.jsp";
    }
    
    
}









