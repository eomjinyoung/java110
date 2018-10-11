// ThreadLocal 사용 전/후
//
package bitcamp.java110.ex13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.Member;

@WebServlet("/ex13/servlet02")
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        // Inventory에서 Member 객체를 꺼내 출력한다.
        Inventory inventory = (Inventory)this.getServletContext()
                                .getAttribute("inventory");
        Member member = inventory.getMember();
        
        // Inventory2에서 Member 객체를 꺼내 출력한다.
        Inventory2 inventory2 = (Inventory2)this.getServletContext()
                                .getAttribute("inventory2");
        Member member2 = inventory2.getMember();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("스레드명 = %s\n", Thread.currentThread().getName());
        out.println("Inventory -----------------");
        out.printf("  no=%d\n", member.getNo());
        out.printf("  name=%s\n", member.getName());
        out.println();
        out.println("Inventory2 -----------------");
        out.printf("  no=%d\n", member2.getNo());
        out.printf("  name=%s\n", member2.getName());
    }
}













