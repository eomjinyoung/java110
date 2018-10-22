package bitcamp.java110.cms.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;
import bitcamp.java110.cms.web.PageController;

@Component("/teacher/detail")
public class TeacherDetailController implements PageController { 
    
    @Autowired
    TeacherService teacherService;
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) {

        int no = Integer.parseInt(request.getParameter("no"));
        Teacher t = teacherService.get(no);
        request.setAttribute("teacher", t);
        return "/teacher/detail.jsp";
    }

}
