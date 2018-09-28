package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        
        int no = Integer.parseInt(request.getParameter("no"));
        
        // 삭제 결과를 출력하고 1초가 경과한 후에 목록 페이지를 요청하도록 
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
        out.println("<h1>학생 삭제 결과</h1>");
        
        try {
            studentDao.delete(no);
            out.println("<p>삭제하였습니다.</p>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>삭제 중 오류 발생!</p>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }

}
