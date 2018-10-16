package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;

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
        memberDao.insert(student);
        studentDao.insert(student);
        
        if (student.getPhoto() != null) {

            HashMap<String,Object> params = new HashMap<>();
            params.put("no", student.getNo());
            params.put("photo", student.getPhoto());
            
            photoDao.insert(params);
        }
    }
    
    @Override
    public List<Student> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("rowNo", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        return studentDao.findAll(params);
    }
    
    @Override
    public Student get(int no) {
        return studentDao.findByNo(no);
    }
    
    @Override
    public void delete(int no) {
        if (studentDao.delete(no) == 0) {
            throw new RuntimeException("해당 번호의 데이터가 없습니다.");
        }
        photoDao.delete(no);
        memberDao.delete(no);
    }
}










