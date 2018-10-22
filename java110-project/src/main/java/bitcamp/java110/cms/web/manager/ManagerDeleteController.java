package bitcamp.java110.cms.web.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.ManagerService;

@Component
public class ManagerDeleteController { 
    
    @Autowired
    ManagerService managerService;
    
    @RequestMapping("/manager/delete")
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        managerService.delete(no);
        return "redirect:list";
    }
    
}
    
    













    
    
    
    
    
    
    
