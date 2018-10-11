package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.DataSource;

public class TeacherMysqlDao implements TeacherDao {

    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Teacher teacher) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql = "insert into p1_tchr(tno,hrpay,subj)"
                    + " values(" + teacher.getNo()
                    + "," + teacher.getPay()
                    + ",'" + teacher.getSubjects()
                    + "')";
            return stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public List<Teacher> findAll() throws DaoException {
        
        ArrayList<Teacher> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " t.hrpay," +
                    " t.subj" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno");
            
            while (rs.next()) {
                Teacher s = new Teacher();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setPay(rs.getInt("hrpay"));
                s.setSubjects(rs.getString("subj"));
                
                list.add(s);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        return list;
    }
    
    public Teacher findByEmail(String email) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " t.hrpay," +
                    " mp.photo" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno" +
                    " left outer join p1_memb_phot mp on t.tno = mp.mno" +
                    " where m.email='" + email + "'");
            
            if (rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setEmail(rs.getString("email"));
                t.setName(rs.getString("name"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                t.setPhoto(rs.getString("photo"));
                
                return t;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public Teacher findByNo(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " t.hrpay," +
                    " t.subj," +
                    " mp.photo" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno" +
                    " left outer join p1_memb_phot mp on t.tno = mp.mno" +
                    " where m.mno=" + no);
            
            if (rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setEmail(rs.getString("email"));
                t.setName(rs.getString("name"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                t.setPhoto(rs.getString("photo"));
                
                return t;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public int delete(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql = "delete from p1_tchr where tno=" + no ;
            return stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    @Override
    public Teacher findByEmailPassword(String email, String password) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " t.hrpay," +
                    " t.subj" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno" +
                    " where m.email='" + email + 
                    "' and m.pwd=password('" + password +
                    "')");
            
            if (rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setEmail(rs.getString("email"));
                t.setName(rs.getString("name"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                return t;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
}









