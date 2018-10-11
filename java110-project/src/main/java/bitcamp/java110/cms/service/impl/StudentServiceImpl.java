package bitcamp.java110.cms.service.impl;

import java.util.List;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;
import bitcamp.java110.cms.util.TransactionManager;

public class StudentServiceImpl implements StudentService {

    MemberDao memberDao;
    StudentDao studentDao;
    PhotoDao photoDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public void add(Student student) {
        // 매니저 등록관 관련된 업무는 Service 객체에서 처리한다.
        TransactionManager txManager = TransactionManager.getInstance();
        
        try {
            txManager.startTransaction();
        
            memberDao.insert(student);
            studentDao.insert(student);
            
            if (student.getPhoto() != null) {
                photoDao.insert(student.getNo(), student.getPhoto());
            }
            
            txManager.commit();
            
        } catch (Exception e) {
            try {txManager.rollback();} catch (Exception e2) {}
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Student> list() {
        return studentDao.findAll();
    }
    
    @Override
    public Student get(int no) {
        return studentDao.findByNo(no);
    }
    
    @Override
    public void delete(int no) {
        TransactionManager txManager = TransactionManager.getInstance();
        
        try {
            txManager.startTransaction();
            
            if (studentDao.delete(no) == 0) {
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










