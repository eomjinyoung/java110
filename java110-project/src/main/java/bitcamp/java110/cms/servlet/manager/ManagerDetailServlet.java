package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        int no = Integer.parseInt(request.getParameter("no"));

        ManagerDao managerDao = (ManagerDao)this.getServletContext()
                .getAttribute("managerDao");
        Manager m = managerDao.findByNo(no);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>매니저 관리</title>");
        out.println("<style>");
        out.println("table, th, td {");
        out.println("    border: 1px solid gray;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>매니저 상세정보</h1>");
        
        if (m == null) {
            out.println("<p>해당 번호의 매니저가 없습니다!</p>");
        } else {
            out.println("<table>");
            out.println("<tbody>");
            out.printf("<tr><th>번호</th><td>%d</td></tr>\n", m.getNo());
            out.printf("<tr><th>이름</th><td>%s</td></tr>\n", m.getName());
            out.printf("<tr><th>이메일</th><td>%s</td></tr>\n", m.getEmail());
            out.printf("<tr><th>암호</th><td>%s</td></tr>\n", m.getPassword());
            out.printf("<tr><th>전화</th><td>%s</td></tr>\n", m.getTel());
            out.printf("<tr><th>직위</th><td>%s</td></tr>\n", m.getPosition());
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("<button type='button' onclick='remove()'>삭제</button>");
        }
        
        out.println("<script>");
        out.println("function remove() {");
        out.printf("    location.href = 'delete?no=%d'\n", m.getNo());
        out.println("}");
        out.println("</script>");
        
        out.println("</body>");
        out.println("</html>");
    }
    
}
    
    













    
    
    
    
    
    
    
