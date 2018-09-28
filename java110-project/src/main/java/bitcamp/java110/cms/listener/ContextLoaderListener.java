package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.util.DataSource;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();

        // DAO가 사용할 DB 커넥션풀 객체 준비
        // => DataSource 객체를 만들 때 컨텍스트 파라미터 값을 꺼내서 사용한다.
        try {
            DataSource dataSource = new DataSource(
                    sc.getInitParameter("jdbc.driver"),
                    sc.getInitParameter("jdbc.url"),
                    sc.getInitParameter("jdbc.username"),
                    sc.getInitParameter("jdbc.password"));
            
            // DAO 객체 생성 및 DB 커네션풀 주입하기
            ManagerMysqlDao managerDao = new ManagerMysqlDao();
            managerDao.setDataSource(dataSource);
            
            StudentMysqlDao studentDao = new StudentMysqlDao();
            studentDao.setDataSource(dataSource);
            
            TeacherMysqlDao teacherDao = new TeacherMysqlDao();
            teacherDao.setDataSource(dataSource);
            
            // 서블릿에서 DAO를 이용할 수 있도록 ServletContext 보관소에 저장하기
            sc.setAttribute("managerDao", managerDao);
            sc.setAttribute("studentDao", studentDao);
            sc.setAttribute("teacherDao", teacherDao);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
