package bitcamp.java110.cms.servlet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {

        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Member loginUser = null;
        
        if (type.equals("manager")) {
            ManagerDao managerDao = (ManagerDao)this.getServletContext()
                    .getAttribute("managerDao");
            loginUser = managerDao.findByEmailPassword(email, password);
            
        } else if (type.equals("student")) {
            StudentDao studentDao = (StudentDao)this.getServletContext()
                    .getAttribute("studentDao");
            loginUser = studentDao.findByEmailPassword(email, password);
            
        } else if (type.equals("teacher")) {
            TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                    .getAttribute("teacherDao");
            loginUser = teacherDao.findByEmailPassword(email, password);
        }
        
        if (loginUser != null) {
            response.sendRedirect("../student/list");
        } else {
            response.sendRedirect("login.html");
        }
    }
}














