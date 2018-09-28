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
        
        // 등록 결과를 출력하고 1초가 경과한 후에 목록 페이지를 요청하도록 
        // "리프래시" 명령을 설정한다.
        // => 응답할 때 응답 헤더로 리프래시에 대한 명령을 웹브라우저에게 전달한다.
        response.setHeader("Refresh", "1;url=list");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>학생 관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 등록 결과</h1>");
        
        try {
            studentDao.insert(s);
            out.println("<p>저장하였습니다.</p>");
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<p>등록 중 오류 발생!</p>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
 
}
