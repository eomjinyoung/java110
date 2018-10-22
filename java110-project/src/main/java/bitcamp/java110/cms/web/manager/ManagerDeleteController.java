package bitcamp.java110.cms.web.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.service.ManagerService;
import bitcamp.java110.cms.web.PageController;

@Component("/manager/delete")
public class ManagerDeleteController implements PageController { 
    
    @Autowired
    ManagerService managerService;
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        managerService.delete(no);
        return "redirect:list";
    }
    
}
    
    













    
    
    
    
    
    
    
