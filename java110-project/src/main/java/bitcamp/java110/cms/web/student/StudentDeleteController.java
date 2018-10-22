package bitcamp.java110.cms.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.StudentService;

@Component
public class StudentDeleteController { 
    
    @Autowired
    StudentService studentService;
    
    @RequestMapping("/student/delete")
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        
        int no = Integer.parseInt(request.getParameter("no"));
        studentService.delete(no);
        return "redirect:list";
    }

}
