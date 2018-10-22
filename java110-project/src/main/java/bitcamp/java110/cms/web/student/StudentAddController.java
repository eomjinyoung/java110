package bitcamp.java110.cms.web.student;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.StudentService;

@Component
public class StudentAddController {

    @Autowired
    StudentService studentService;
    
    @RequestMapping("/student/add")
    public String add(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        if (request.getMethod().equals("GET")) {
            return "/student/form.jsp";
        }

        request.setCharacterEncoding("UTF-8");
        
        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setTel(request.getParameter("tel"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        
        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(request.getServletContext()
                       .getRealPath("/upload/" + filename));
            s.setPhoto(filename);
        }
        
        studentService.add(s);
        return "redirect:list";
        
    }
 
}
