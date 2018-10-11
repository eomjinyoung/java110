package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.MemberMysqlDao;
import bitcamp.java110.cms.dao.impl.PhotoMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.service.impl.AuthServiceImpl;
import bitcamp.java110.cms.service.impl.ManagerServiceImpl;
import bitcamp.java110.cms.service.impl.StudentServiceImpl;
import bitcamp.java110.cms.service.impl.TeacherServiceImpl;
import bitcamp.java110.cms.util.DataSource;
import bitcamp.java110.cms.util.TransactionManager;

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
            
            TransactionManager txManager = TransactionManager.getInstance();
            txManager.setDataSource(dataSource);
            
            // DAO 객체 생성 및 DB 커네션풀 주입하기
            MemberMysqlDao memberDao = new MemberMysqlDao();
            memberDao.setDataSource(dataSource);
            
            ManagerMysqlDao managerDao = new ManagerMysqlDao();
            managerDao.setDataSource(dataSource);
            
            StudentMysqlDao studentDao = new StudentMysqlDao();
            studentDao.setDataSource(dataSource);
            
            TeacherMysqlDao teacherDao = new TeacherMysqlDao();
            teacherDao.setDataSource(dataSource);
            
            PhotoMysqlDao photoDao = new PhotoMysqlDao();
            photoDao.setDataSource(dataSource);
            
            // 서비스 객체 준비하기
            ManagerServiceImpl managerService = new ManagerServiceImpl();
            managerService.setMemberDao(memberDao);
            managerService.setManagerDao(managerDao);
            managerService.setPhotoDao(photoDao);
            
            StudentServiceImpl studentService = new StudentServiceImpl();
            studentService.setMemberDao(memberDao);
            studentService.setStudentDao(studentDao);
            studentService.setPhotoDao(photoDao);
            
            TeacherServiceImpl teacherService = new TeacherServiceImpl();
            teacherService.setMemberDao(memberDao);
            teacherService.setTeacherDao(teacherDao);
            teacherService.setPhotoDao(photoDao);
            
            AuthServiceImpl authService = new AuthServiceImpl();
            authService.setManagerDao(managerDao);
            authService.setStudentDao(studentDao);
            authService.setTeacherDao(teacherDao);
            
            // 서블릿에서 Service를 이용할 수 있도록 ServletContext 보관소에 저장하기
            sc.setAttribute("managerService", managerService);
            sc.setAttribute("studentService", studentService);
            sc.setAttribute("teacherService", teacherService);
            sc.setAttribute("authService", authService);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







