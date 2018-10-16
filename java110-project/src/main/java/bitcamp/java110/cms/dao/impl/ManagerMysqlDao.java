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
        /*
        Connection con = null;
        PreparedStatement stmt = null;
        
        
        try {
            con = dataSource.getConnection();
            String sql = "insert into p1_mgr(mrno,posi) values(?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, manager.getNo());
            stmt.setString(2, manager.getPosition());
            return stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        */
        return 0;
    }
    
    @Override
    public List<Manager> findAll(Map<String,Object> params) {
        
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
           return sqlSession.selectList(
                   "bitcamp.java110.cms.dao.ManagerDao.findAll", params); 
        }
        /*
        
        ArrayList<Manager> list = new ArrayList<>();
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));
                
                list.add(mgr);
            }
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        return list;
        */
    }
    
    @Override
    public Manager findByEmail(String email) {
        /*
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " mr.posi," +
                    " mp.photo" +
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno" +
                    " left outer join p1_memb_phot mp on mr.mrno = mp.mno" +
                    " where m.email=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                mgr.setPhoto(rs.getString("photo"));
                
                return mgr;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        */
        return null;
    }
    
    @Override
    public Manager findByNo(int no) {
        /*
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " mr.posi," +
                    " mp.photo" +
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno" +
                    " left outer join p1_memb_phot mp on mr.mrno = mp.mno" +
                    " where m.mno=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, no);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                mgr.setPhoto(rs.getString("photo"));
                
                return mgr;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        */
        return null;
    }
    
    @Override
    public int delete(int no) {
        /*
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "delete from p1_mgr where mrno=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, no);
            return stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        */
        return 0;
    }
    
    @Override
    public Manager findByEmailPassword(String email, String password) {
        /*
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno" +
                    " where m.email=? and m.pwd=password(?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                
                return mgr;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        */
        return null;
    }
    
}
























