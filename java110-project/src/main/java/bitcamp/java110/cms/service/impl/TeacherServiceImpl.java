package bitcamp.java110.cms.service.impl;

import java.util.List;

import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;
import bitcamp.java110.cms.util.TransactionManager;

public class TeacherServiceImpl implements TeacherService {

    MemberDao memberDao;
    TeacherDao teacherDao;
    PhotoDao photoDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public void add(Teacher teacher) {
        // 매니저 등록관 관련된 업무는 Service 객체에서 처리한다.
        TransactionManager txManager = TransactionManager.getInstance();
        
        try {
            txManager.startTransaction();
            
            memberDao.insert(teacher);
            teacherDao.insert(teacher);
            
            if (teacher.getPhoto() != null) {
                photoDao.insert(teacher.getNo(), teacher.getPhoto());
            }
            
            txManager.commit();
            
        } catch (Exception e) {
            try {txManager.rollback();} catch (Exception e2) {}
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Teacher> list() {
        return teacherDao.findAll();
    }
    
    @Override
    public Teacher get(int no) {
        return teacherDao.findByNo(no);
    }
    
    @Override
    public void delete(int no) {
        TransactionManager txManager = TransactionManager.getInstance();
        
        try {
            txManager.startTransaction();
            
            if (teacherDao.delete(no) == 0) {
                throw new RuntimeException("해당 번호의 데이터가 없습니다.");
            }
            photoDao.delete(no);
            memberDao.delete(no);
            
            txManager.commit();
            
        } catch (Exception e) {
            try {txManager.rollback();} catch (Exception e2) {}
            throw new RuntimeException(e);
        }
    }
}










