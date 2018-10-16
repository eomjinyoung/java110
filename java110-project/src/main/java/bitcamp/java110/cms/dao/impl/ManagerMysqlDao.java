package bitcamp.java110.cms.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

public class ManagerMysqlDao implements ManagerDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    @Override
    public int insert(Manager manager) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            return sqlSession.insert(
                    "bitcamp.java110.cms.dao.ManagerDao.insert", manager); 
        }
    }
    
    @Override
    public List<Manager> findAll(Map<String,Object> params) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
           return sqlSession.selectList(
                   "bitcamp.java110.cms.dao.ManagerDao.findAll", params); 
        }
    }
    
    @Override
    public Manager findByEmail(String email) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.ManagerDao.findByEmail", email); 
        }
    }
    
    @Override
    public Manager findByNo(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.ManagerDao.findByNo", no); 
        }
    }
    
    @Override
    public int delete(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            return sqlSession.delete(
                    "bitcamp.java110.cms.dao.ManagerDao.delete", no); 
        }
    }
    
    @Override
    public Manager findByEmailPassword(Map<String,Object> params) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                "bitcamp.java110.cms.dao.ManagerDao.findByEmailPassword", 
                params); 
        }
    }
    
}
























