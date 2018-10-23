package bitcamp.java110.cms.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;
    
    @RequestMapping("/auth/login")
    public String login(
            String type,
            String email,
            String password,
            String save,
            HttpServletRequest request, 
            HttpServletResponse response,
            HttpSession session) {
        
        if (request.getMethod().equals("GET")) {
            return  "/auth/form.jsp";
        }
        
        if (save != null) {// 이메일 저장하기를 체크했다면,
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 15);
            response.addCookie(cookie);
            
        } else {// 이메일을 저장하고 싶지 않다면,
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        
        Member loginUser = authService.getMember(email, password, type);
        
        if (loginUser != null) {
            // 회원 정보를 세션에 보관한다.
            session.setAttribute("loginUser", loginUser);
            String redirectUrl = null;
            
            switch (type) {
            case "student":
                redirectUrl = "../student/list";
                break;
            case "teacher":
                redirectUrl = "../teacher/list";
                break; 
            case "manager":
                redirectUrl = "../manager/list";
                break; 
            }
            return "redirect:" + redirectUrl;
            
        } else {
            session.invalidate();
            return "redirect:login";
        }
    }
    
    @RequestMapping("/auth/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}














