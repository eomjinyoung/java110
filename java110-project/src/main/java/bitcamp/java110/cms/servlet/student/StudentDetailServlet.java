package bitcamp.java110.cms.servlet.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;

@WebServlet("/student/detail")
public class StudentDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        
        int no = Integer.parseInt(request.getParameter("no"));
        
        StudentService studentService = (StudentService)this.getServletContext()
                .getAttribute("studentService");
        
        Student s = studentService.get(no);
        request.setAttribute("student", s);
        
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher(
                "/student/detail.jsp");
        rd.include(request, response);
    }

}
