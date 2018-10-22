package bitcamp.java110.cms.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.TeacherService;

@Component
public class TeacherController { 
    
    @Autowired
    TeacherService teacherService;
    
    @RequestMapping("/teacher/list")
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
        
        List<Teacher> list = teacherService.list(pageNo, pageSize);
        request.setAttribute("list", list);
        return "/teacher/list.jsp";
    }
    
    @RequestMapping("/teacher/detail")
    public String detail(
            HttpServletRequest request, 
            HttpServletResponse response) {

        int no = Integer.parseInt(request.getParameter("no"));
        Teacher t = teacherService.get(no);
        request.setAttribute("teacher", t);
        return "/teacher/detail.jsp";
    }
    
    @RequestMapping("/teacher/add")
    public String add(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        if (request.getMethod().equals("GET")) {
            return "/teacher/form.jsp";
        }
        
        request.setCharacterEncoding("UTF-8");
        
        Teacher t = new Teacher();
        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("password"));
        t.setTel(request.getParameter("tel"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setSubjects(request.getParameter("subjects"));
        
        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(request.getServletContext()
                       .getRealPath("/upload/" + filename));
            t.setPhoto(filename);
        }
        
        teacherService.add(t);
        request.setAttribute("viewUrl", "redirect:list");
        return "redirect:list";
        
    }
    
    @RequestMapping("/teacher/delete")
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        teacherService.delete(no);
        return "redirect:list";
    }
}
