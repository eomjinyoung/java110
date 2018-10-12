package ex03;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {

    // Mybatis 객체를 사용하기 위해 주입받는다.
    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Member member) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.insert("memberdao.insert", member);
        } finally {
            sqlSession.close();
        }
    }
    
    public int delete(int no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.delete("memberdao.delete", no); 
        } finally {
            sqlSession.close();
        }
    }
    
    public List<Member> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("memberdao.findAll");
        } finally {
            sqlSession.close();
        }
    }
}
























