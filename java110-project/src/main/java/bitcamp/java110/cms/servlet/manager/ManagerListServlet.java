package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/list")
public class ManagerListServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        // JSP가 사용할 데이터 준비 
        ManagerDao managerDao = (ManagerDao)this.getServletContext()
                .getAttribute("managerDao");
        List<Manager> list = managerDao.findAll();
        
        // JSP 사용할 수 있도록 ServletRequest 보관소에 저장한다.
        request.setAttribute("list", list);
        
        // JSP로 실행을 위임하기 전에 응답 콘텐츠의 타입을 설정한다.
        response.setContentType("text/html;charset=UTF-8");
        
        // JSP로 실행을 위임한다.
        RequestDispatcher rd = request.getRequestDispatcher(
                "/manager/list.jsp");
        rd.include(request, response);
        
        // 이제 서블릿은 UI를 생성하는 코드가 없다.
        // UI 생성은 JSP 페이지에 맡겼다.
        // Servlet 
        //   - 클라이언트 요청을 받고 요청 파라미터 값을 사용하기 적합하게 가공하는 일을 한다.
        //   - DAO를 호출하여 데이터를 준비한다.
        //   - JSP에게 실행을 위임한다.
        //   - "Controller" 컴포넌트라 부른다.
        // DAO
        //   - DBMS와 연동하여 데이터를 처리한다.
        //   - "Model" 컴포넌트라 부른다.
        // JSP
        //   - 클라이언트가 출력할 화면을 생성한다.
        //   - "View" 컴포넌트라 부른다.
        //
        // 클라이언트 요청이 들어왔을 때
        // 이렇게 역할을 쪼개서 처리하는 방식을 
        // "MVC 아키텍처(모델)"이라 부른다.
        // 
        // MVC 모델 1
        //   요청 ---> JSP ---> DAO ---> DBMS
        //       <---     <---     <---
        //
        // MVC 모델 2
        //   요청 ---> Servlet ---> DAO ---> DBMS
        //              ^ |
        //              | |
        //              | v
        //           JSP 페이지
        // 
    }
}
    
    













    
    
    
    
    
    
    
