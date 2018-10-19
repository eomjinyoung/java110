package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@MultipartConfig(maxFileSize=2_000_000)
@WebServlet("/manager/add")
public class ManagerAddServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        // form.jsp 인클루딩
        RequestDispatcher rd = request.getRequestDispatcher(
                "/manager/form.jsp");
        rd.include(request, response);
    }
    
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
        
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext()
                                        .getAttribute("iocContainer");
        ManagerService managerService = 
                iocContainer.getBean(ManagerService.class);
        
        try {
            // 사진 데이터 처리
            Part part = request.getPart("file1");
            if (part.getSize() > 0) {
                String filename = UUID.randomUUID().toString();
                part.write(this.getServletContext()
                           .getRealPath("/upload/" + filename));
                m.setPhoto(filename);
            }
            
            managerService.add(m);
            
            // 오류 없이 등록에 성공했으면, 
            // 목록 페이지를 다시 요청하라고 redirect 명령을 보낸다.
            response.sendRedirect("list");
            
        } catch(Exception e) {
            // 오류 내용을 처리하는 서블릿으로 실행을 위임한다.
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            
            // 위임하기 전에 작업을 수행하는데 필요한 정보를 
            // ServletRequest 보관소에 담아 전달한다.
            request.setAttribute("error", e);
            request.setAttribute("message", "매니저 등록 오류!");
            request.setAttribute("refresh", "3;url=list");
            
            // 작업을 위임한다.
            rd.forward(request, response);
        }
        
    }
    
}
    
    













    
    
    
    
    
    
    
