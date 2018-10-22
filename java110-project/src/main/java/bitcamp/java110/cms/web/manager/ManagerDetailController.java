package bitcamp.java110.cms.web.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.ManagerService;

@Component
public class ManagerDetailController { 
    
    @Autowired
    ManagerService managerService;
    
    @RequestMapping("/manager/detail")
    public String detail(
            HttpServletRequest request, 
            HttpServletResponse response) {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Manager m = managerService.get(no);
        request.setAttribute("manager", m);
        return "/manager/detail.jsp";
    }
    
}
    
    













    
    
    
    
    
    
    
