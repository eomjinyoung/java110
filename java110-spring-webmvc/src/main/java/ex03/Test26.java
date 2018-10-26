// 세션 다루기 - HttpSession 객체를 직접 사용하기
package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03/test26")
public class Test26 {
    
    // 테스트:
    //      http://localhost:8888/app/ex03/test26/m1
    //
    @GetMapping("m1")
    public void m1() throws Exception {
    }
    
    // HttpSession 객체가 필요하면 파라미터로 선언하라.
    // 프론트 컨트롤러가 세션 객체를 넘겨 줄 것이다.
    @PostMapping("m2")
    public void m2(String name, HttpSession session) throws Exception {
        // 세션에 클라이언트가 보낸 데이터를 보관한다.
        session.setAttribute("name", name);
        
        // m1()과 마찬가지로 view url을 리턴하지 않으면,
        // 프론트 컨트롤러는 request handler의 url에 기반하여 
        // JSP 페이지를 찾는다.
        // 단 InternalResourceViewResolver 가 사용될 때
        // 이 메서드의 view url은 다음과 같을 것이다.
        //      "/WEB-INF/jsp/" + request handler url + ".jsp"
        //      => /WEB-INF/jsp/ex03/test26/m2.jsp 
    }
    
    @PostMapping("m3")
    public void m3(int age, HttpSession session) throws Exception {
        session.setAttribute("age", age);
    }
    
    @PostMapping("m4")
    public void m4(String teacher, HttpSession session) throws Exception {
        if (teacher != null) {
            session.setAttribute("teacher", true);
        } else {
            session.setAttribute("teacher", false);
        }
    }
    
    // 같은 이름으로 여러 개의 값이 넘어올 때는 배열로 받는다.
    @PostMapping("m5")
    public void m5(String[] language, HttpSession session) throws Exception {
        if (language != null) {
            session.setAttribute("language", language);
        } 
    }
    
    @PostMapping("m6")
    public void m6(String gender, HttpSession session) throws Exception {
        session.setAttribute("gender", gender);
    }
    
    @GetMapping("m7")
    public void m7() throws Exception {
    }
    
    @GetMapping("m8")
    public void m8(HttpSession session) throws Exception {
        session.invalidate();
    }
    

    
    
}








