package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/teacher/add")
public class TeacherAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    TeacherMysqlDao teacherDao;
    
    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        teacherDao = new TeacherMysqlDao();
        teacherDao.setDataSource(dataSource);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        Teacher m = new Teacher();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPay(Integer.parseInt(request.getParameter("pay")));
        m.setSubjects(request.getParameter("subjects"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (teacherDao.insert(m) > 0) {
            out.println("저장하였습니다.");
        } else {
            out.println("같은 이메일의 강사가 존재합니다.");
        }
    }

}
