package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired MemberDao memberDao;
    @Autowired PhotoDao photoDao;
    @Autowired TeacherDao teacherDao;

    @Override
    public void add(Teacher teacher) {
        memberDao.insert(teacher);
        teacherDao.insert(teacher);
        
        if (teacher.getPhoto() != null) {

            HashMap<String,Object> params = new HashMap<>();
            params.put("no", teacher.getNo());
            params.put("photo", teacher.getPhoto());
            
            photoDao.insert(params);
        }
    }
    
    @Override
    public List<Teacher> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("rowNo", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        return teacherDao.findAll(params);
    }
    
    @Override
    public Teacher get(int no) {
        return teacherDao.findByNo(no);
    }
    
    @Override
    public void delete(int no) {
        if (teacherDao.delete(no) == 0) {
            throw new RuntimeException("해당 번호의 데이터가 없습니다.");
        }
        photoDao.delete(no);
        memberDao.delete(no);
    }
}










