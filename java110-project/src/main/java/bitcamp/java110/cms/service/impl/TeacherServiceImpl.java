package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void add(Teacher teacher) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MemberDao memberDao = session.getMapper(MemberDao.class);
            TeacherDao teacherDao = session.getMapper(TeacherDao.class);
            PhotoDao photoDao = session.getMapper(PhotoDao.class);
            
            memberDao.insert(teacher);
            teacherDao.insert(teacher);
            
            if (teacher.getPhoto() != null) {
    
                HashMap<String,Object> params = new HashMap<>();
                params.put("no", teacher.getNo());
                params.put("photo", teacher.getPhoto());
                
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
    public List<Teacher> list(int pageNo, int pageSize) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TeacherDao teacherDao = session.getMapper(TeacherDao.class);
            
            HashMap<String,Object> params = new HashMap<>();
            params.put("rowNo", (pageNo - 1) * pageSize);
            params.put("size", pageSize);
            
            return teacherDao.findAll(params);
        }
    }
    
    @Override
    public Teacher get(int no) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TeacherDao teacherDao = session.getMapper(TeacherDao.class);
            return teacherDao.findByNo(no);
        }
    }
    
    @Override
    public void delete(int no) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MemberDao memberDao = session.getMapper(MemberDao.class);
            TeacherDao teacherDao = session.getMapper(TeacherDao.class);
            PhotoDao photoDao = session.getMapper(PhotoDao.class);
            
            if (teacherDao.delete(no) == 0) {
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










