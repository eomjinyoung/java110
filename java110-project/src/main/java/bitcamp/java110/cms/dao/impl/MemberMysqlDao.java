package bitcamp.java110.cms.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.domain.Member;

public class MemberMysqlDao implements MemberDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public int insert(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert(
                "bitcamp.java110.cms.dao.MemberDao.insert", member);
        }
    }
    
    @Override
    public int delete(int no) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.delete(
                "bitcamp.java110.cms.dao.MemberDao.delete", no);
        }
    }

}
























