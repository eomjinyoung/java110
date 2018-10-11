// ThreadLocal 사용 전/후
//
package bitcamp.java110.ex13;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.Member;

@WebServlet("/ex13/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        // Member 객체를 만든 후에 Inventory 객체에 보관한다.
        Member member = new Member();
        member.setNo(Integer.parseInt(request.getParameter("no")));
        member.setName(request.getParameter("name"));
        
        // ThreadLocal이 아닌 일반 인스턴스 변수에 저장하기
        Inventory inventory = (Inventory)this.getServletContext()
                                .getAttribute("inventory");
        inventory.setMember(member);
        
        // ThreadLocal 인스턴스 변수에 저장하기
        Inventory2 inventory2 = (Inventory2)this.getServletContext()
                .getAttribute("inventory2");
        inventory2.setMember(member);
        
        int delayTime = 
                Integer.parseInt(request.getParameter("delayTime"));
        try {
            Thread.sleep(delayTime); // 밀리초
        } catch (Exception e) {}
        
        // Servlet03으로 실행을 위임한다.
        RequestDispatcher rd = 
                request.getRequestDispatcher("/ex13/servlet02");
        rd.forward(request, response);
        
    }
}













