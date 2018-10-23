package bitcamp.java110.cms.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.mvc.RequestParam;
import bitcamp.java110.cms.service.ManagerService;

@Component
public class ManagerController { 
    
    @Autowired
    ManagerService managerService;
    
    @Autowired
    ServletContext sc;
    
    @RequestMapping("/manager/list")
    public String list(
            @RequestParam(value="pageNo",defaultValue="1") int pageNo,
            @RequestParam(value="pageSize",defaultValue="3") int pageSize,
            HttpServletRequest request) {
        
        if (pageNo < 1)
            pageNo = 1;
        
        if (pageSize < 3 || pageSize > 10)
            pageSize = 3;
        
        List<Manager> list = managerService.list(pageNo, pageSize);
        request.setAttribute("list", list);
        return "/manager/list.jsp";
    }
    
    @RequestMapping("/manager/detail")
    public String detail(
            @RequestParam(value="no") int no,
            HttpServletRequest request) {
        
        Manager m = managerService.get(no);
        request.setAttribute("manager", m);
        return "/manager/detail.jsp";
    }
    
    @RequestMapping("/manager/add")
    public String add(
            Manager manager,
            HttpServletRequest request) throws Exception {
        
        if (request.getMethod().equals("GET")) {
            return "/manager/form.jsp";
        }

        request.setCharacterEncoding("UTF-8");
        
        // 사진 데이터 처리
        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(sc.getRealPath("/upload/" + filename));
            manager.setPhoto(filename);
        }
        
        managerService.add(manager);
        
        return "redirect:list";
    }
    
    @RequestMapping("/manager/delete")
    public String delete(
            @RequestParam("no") int no,
            HttpServletRequest request) throws Exception {
        
        managerService.delete(no);
        return "redirect:list";
    }
    
}







