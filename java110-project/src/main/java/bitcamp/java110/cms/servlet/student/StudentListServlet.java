package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    StudentMysqlDao studentDao;
    
    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        studentDao = new StudentMysqlDao();
        studentDao.setDataSource(dataSource);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Student> list = studentDao.findAll();
        for (Student s : list) {
            out.printf("%d, %s, %s, %s, %b\n",
                    s.getNo(),
                    s.getName(), 
                    s.getEmail(), 
                    s.getSchool(),
                    s.isWorking());
        }
    }
}
