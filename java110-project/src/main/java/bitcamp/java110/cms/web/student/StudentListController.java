package bitcamp.java110.cms.web.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.StudentService;

@Component
public class StudentListController { 
    
    @Autowired
    StudentService studentService;
    
    @RequestMapping("/student/list")
    public String list(
            HttpServletRequest request, 
            HttpServletResponse response) {

        int pageNo = 1;
        int pageSize = 3;
        
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if (pageNo < 1)
                pageNo = 1;
        }
        
        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if (pageSize < 3 || pageSize > 10)
                pageSize = 3;
        }
        
        List<Student> list = studentService.list(pageNo, pageSize);
        request.setAttribute("list", list);
        return "/student/list.jsp";
    }
}
