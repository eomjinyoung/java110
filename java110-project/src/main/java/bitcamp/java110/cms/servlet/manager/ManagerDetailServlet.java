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
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (m == null) {
            out.println("해당 번호의 매니저가 없습니다!");
            return;
        }
        
        out.printf("이름: %s\n", m.getName());
        out.printf("이메일: %s\n", m.getEmail());
        out.printf("암호: %s\n", m.getPassword());
        out.printf("직위: %s\n", m.getPosition());
        out.printf("전화: %s\n", m.getTel());
    }
    
}
    
    













    
    
    
    
    
    
    
