package bitcamp.java110.cms.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.TeacherService;

@Component
public class TeacherDetailController { 
    
    @Autowired
    TeacherService teacherService;
    
    @RequestMapping("/teacher/detail")
    public String detail(
            HttpServletRequest request, 
            HttpServletResponse response) {

        int no = Integer.parseInt(request.getParameter("no"));
        Teacher t = teacherService.get(no);
        request.setAttribute("teacher", t);
        return "/teacher/detail.jsp";
    }

}
