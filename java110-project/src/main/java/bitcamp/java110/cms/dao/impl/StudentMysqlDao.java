package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.DataSource;

public class StudentMysqlDao implements StudentDao {

    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Student student) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql = "insert into p1_stud(sno,schl,work)"
                    + " values(" + student.getNo()
                    + ",'" + student.getSchool()
                    + "','" + (student.isWorking()?'Y':'N')
                    + "')";
            return stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public List<Student> findAll() throws DaoException {
        
        ArrayList<Student> list = new ArrayList<>();
        
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
                    " s.schl," +
                    " s.work" +
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno");
            
            while (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                
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
    
    public Student findByEmail(String email) throws DaoException {
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
                    " s.schl," +
                    " s.work," +
                    " mp.photo" +
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno" +
                    " left outer join p1_memb_phot mp on s.sno = mp.mno" +
                    " where m.email='" + email + "'");
            
            if (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                s.setPhoto(rs.getString("photo"));
                
                return s;
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
    
    public Student findByNo(int no) throws DaoException {
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
                    " s.schl," +
                    " s.work," +
                    " mp.photo" +
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno" +
                    " left outer join p1_memb_phot mp on s.sno = mp.mno" +
                    " where m.mno=" + no);
            
            if (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                s.setPhoto(rs.getString("photo"));
                
                return s;
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
            
            String sql = "delete from p1_stud where sno=" + no ;
            return stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    @Override
    public Student findByEmailPassword(String email, String password) throws DaoException {
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
                    " s.schl," +
                    " s.work" + 
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno" +
                    " where m.email='" + email + 
                    "' and m.pwd=password('" + password +
                    "')");
            
            if (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                
                
                return s;
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









