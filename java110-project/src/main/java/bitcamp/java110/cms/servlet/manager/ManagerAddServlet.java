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

@WebServlet("/manager/add")
public class ManagerAddServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        // POST 방식으로 들어온 한글 데이터는 
        // 다음 메서드를 호출하여 어떤 인코딩인지 알려줘야 
        // getParameter() 호출할 때 정상적으로 디코딩 할 것이다.
        request.setCharacterEncoding("UTF-8");
        
        Manager m = new Manager();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPosition(request.getParameter("position"));
        
        ManagerDao managerDao = (ManagerDao)this.getServletContext()
                .getAttribute("managerDao");
        
        try {
            managerDao.insert(m);
            
            // 오류 없이 등록에 성공했으면, 
            // 목록 페이지를 다시 요청하라고 redirect 명령을 보낸다.
            response.sendRedirect("list");
            
        } catch(Exception e) {
            e.printStackTrace();
            // 등록 오류 내용을 출력하고 1초가 경과한 후에 목록 페이지를 요청하도록 
            // "리프래시" 명령을 설정한다.
            // => 응답할 때 응답 헤더로 리프래시에 대한 명령을 웹브라우저에게 전달한다.
            response.setHeader("Refresh", "3;url=list");
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>매니저 관리</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>매니저 등록 오류!</h1>");
            out.printf("<p>%s</p>\n", e.getMessage());
            out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
}
    
    













    
    
    
    
    
    
    
