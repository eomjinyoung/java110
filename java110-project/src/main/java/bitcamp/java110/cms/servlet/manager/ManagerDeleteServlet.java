package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.service.ManagerService;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        int no = Integer.parseInt(request.getParameter("no"));
        
        
        ManagerService managerService = 
                (ManagerService)this.getServletContext()
                                    .getAttribute("managerService");
        
        try {
            managerService.delete(no);
            response.sendRedirect("list");
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "매니저 삭제 오류!");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
        
    }
    
}
    
    













    
    
    
    
    
    
    
