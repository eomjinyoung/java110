package bitcamp.java110.cms.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.service.TeacherService;
import bitcamp.java110.cms.web.PageController;

@Component("/teacher/delete")
public class TeacherDeleteController implements PageController { 
    
    @Autowired
    TeacherService teacherService;
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        teacherService.delete(no);
        return "redirect:list";
    }

}
