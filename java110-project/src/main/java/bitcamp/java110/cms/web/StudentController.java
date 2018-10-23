package bitcamp.java110.cms.web;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;

@Controller
public class StudentController { 
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    ServletContext sc;
    
    @RequestMapping("/student/list")
    public String list(
            @RequestParam(value="pageNo",defaultValue="1") int pageNo,
            @RequestParam(value="pageSize",defaultValue="3") int pageSize,
            Map<String,Object> map) {

        if (pageNo < 1)
            pageNo = 1;

        if (pageSize < 3 || pageSize > 10)
            pageSize = 3;
        
        List<Student> list = studentService.list(pageNo, pageSize);
        map.put("list", list);
        return "/student/list.jsp";
    }
    
    @RequestMapping("/student/detail")
    public String detail(
            int no,
            Map<String,Object> map) {

        Student s = studentService.get(no);
        map.put("student", s);
        return "/student/detail.jsp";
    }
    
    @RequestMapping("/student/add")
    public String add(
            Student student,
            HttpServletRequest request) throws Exception {
        
        if (request.getMethod().equals("GET")) {
            return "/student/form.jsp";
        }

        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(sc.getRealPath("/upload/" + filename));
            student.setPhoto(filename);
        }
        
        studentService.add(student);
        
        return "redirect:list";
        
    }
    
    @RequestMapping("/student/delete")
    public String delete(int no) throws Exception {
        
        studentService.delete(no);
        return "redirect:list";
    }
}
