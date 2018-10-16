package bitcamp.java110.cms.service.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

public class AuthServiceImpl implements AuthService {

    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Member getMember(
            String email, String password, String memberType) {
        
        try (SqlSession session = sqlSessionFactory.openSession()) {
            HashMap<String,Object> params = new HashMap<>();
            params.put("email", email);
            params.put("password", password);
            
            if (memberType.equals("manager")) {
                ManagerDao managerDao = 
                        session.getMapper(ManagerDao.class);
                return managerDao.findByEmailPassword(params);
                
            } else if (memberType.equals("student")) {
                StudentDao studentDao = 
                        session.getMapper(StudentDao.class);
                return studentDao.findByEmailPassword(params);
                
            } else if (memberType.equals("teacher")) {
                TeacherDao teacherDao = 
                        session.getMapper(TeacherDao.class);
                return teacherDao.findByEmailPassword(params);
                
            } else {
                return null;
            }
        }
    }
    
}










