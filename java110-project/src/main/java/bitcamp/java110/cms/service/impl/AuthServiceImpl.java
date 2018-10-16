package bitcamp.java110.cms.service.impl;

import java.util.HashMap;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

public class AuthServiceImpl implements AuthService {

    ManagerDao managerDao;
    StudentDao studentDao;
    TeacherDao teacherDao;

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @Override
    public Member getMember(
            String email, String password, String memberType) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        if (memberType.equals("manager")) {
            return managerDao.findByEmailPassword(params);
            
        } else if (memberType.equals("student")) {
            return studentDao.findByEmailPassword(params);
            
        } else if (memberType.equals("teacher")) {
            return teacherDao.findByEmailPassword(params);
            
        } else {
            return null;
        }
    }
    
}










