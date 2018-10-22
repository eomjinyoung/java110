package bitcamp.java110.cms.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.mvc.RequestMapping;

@Component
public class LogoutController {

    @RequestMapping("/auth/logout")
    public String logout(
            HttpServletRequest request, 
            HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        return "redirect:login";
    }
}














