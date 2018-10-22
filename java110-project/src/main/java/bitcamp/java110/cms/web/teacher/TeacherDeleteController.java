package bitcamp.java110.cms.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.TeacherService;

@Component
public class TeacherDeleteController { 
    
    @Autowired
    TeacherService teacherService;
    
    @RequestMapping("/teacher/delete")
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        teacherService.delete(no);
        return "redirect:list";
    }

}
