package bitcamp.java110.cms.web.manager;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;
import bitcamp.java110.cms.web.PageController;

@Component("/manager/add")
public class ManagerAddServlet implements PageController { 
    
    @Autowired
    ManagerService managerService;
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        if (request.getMethod().equals("GET")) {
            return "/manager/form.jsp";
        }

        request.setCharacterEncoding("UTF-8");
        
        Manager m = new Manager();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPosition(request.getParameter("position"));
        
        // 사진 데이터 처리
        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(request.getServletContext()
                       .getRealPath("/upload/" + filename));
            m.setPhoto(filename);
        }
        
        managerService.add(m);
        return "redirect:list";
    }
    
}
    
    













    
    
    
    
    
    
    
