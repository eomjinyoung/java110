package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setTel(request.getParameter("tel"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        
        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");
        
        try {
            studentDao.insert(s);
            response.sendRedirect("list");
            
        } catch(Exception e) {
            e.printStackTrace();

            response.setHeader("Refresh", "3;url=list");
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>학생 관리</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>학생 등록 오류!</h1>");
            out.printf("<p>%s</p>\n", e.getMessage());
            out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
 
}
