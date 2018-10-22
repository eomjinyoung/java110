package bitcamp.java110.cms.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.StudentService;

@Component
public class StudentDetailController { 
    
    @Autowired
    StudentService studentService;
    
    @RequestMapping("/student/detail")
    public String detail(
            HttpServletRequest request, 
            HttpServletResponse response) {

        int no = Integer.parseInt(request.getParameter("no"));
        Student s = studentService.get(no);
        request.setAttribute("student", s);
        return "/student/detail.jsp";
    }

}
