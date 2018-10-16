package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void add(Manager manager) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MemberDao memberDao = session.getMapper(MemberDao.class);
            ManagerDao managerDao = session.getMapper(ManagerDao.class);
            PhotoDao photoDao = session.getMapper(PhotoDao.class);
            
            memberDao.insert(manager);
            managerDao.insert(manager);
            
            if (manager.getPhoto() != null) {
                
                HashMap<String,Object> params = new HashMap<>();
                params.put("no", manager.getNo());
                params.put("photo", manager.getPhoto());
                
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
    public List<Manager> list(int pageNo, int pageSize) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            
            ManagerDao managerDao = session.getMapper(ManagerDao.class);
            
            HashMap<String,Object> params = new HashMap<>();
            params.put("rowNo", (pageNo - 1) * pageSize);
            params.put("size", pageSize);
            
            return managerDao.findAll(params);
        }
    }
    
    @Override
    public Manager get(int no) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ManagerDao managerDao = session.getMapper(ManagerDao.class);
            return managerDao.findByNo(no);
        }
    }
    
    @Override
    public void delete(int no) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MemberDao memberDao = session.getMapper(MemberDao.class);
            ManagerDao managerDao = session.getMapper(ManagerDao.class);
            PhotoDao photoDao = session.getMapper(PhotoDao.class);
            
            if (managerDao.delete(no) == 0) {
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










