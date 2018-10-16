package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;

public class StudentServiceImpl implements StudentService {

    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void add(Student student) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MemberDao memberDao = session.getMapper(MemberDao.class);
            StudentDao studentDao = session.getMapper(StudentDao.class);
            PhotoDao photoDao = session.getMapper(PhotoDao.class);
            
            memberDao.insert(student);
            studentDao.insert(student);
            
            if (student.getPhoto() != null) {
    
                HashMap<String,Object> params = new HashMap<>();
                params.put("no", student.getNo());
                params.put("photo", student.getPhoto());
                
                photoDao.insert(params);
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public List<Student> list(int pageNo, int pageSize) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            
            HashMap<String,Object> params = new HashMap<>();
            params.put("rowNo", (pageNo - 1) * pageSize);
            params.put("size", pageSize);
            
            return studentDao.findAll(params);
        }
    }
    
    @Override
    public Student get(int no) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.findByNo(no);
        }
    }
    
    @Override
    public void delete(int no) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MemberDao memberDao = session.getMapper(MemberDao.class);
            StudentDao studentDao = session.getMapper(StudentDao.class);
            PhotoDao photoDao = session.getMapper(PhotoDao.class);
            
            if (studentDao.delete(no) == 0) {
                throw new RuntimeException("해당 번호의 데이터가 없습니다.");
            }
            photoDao.delete(no);
            memberDao.delete(no);
            
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}










