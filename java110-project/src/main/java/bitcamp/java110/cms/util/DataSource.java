package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    
    Connection con;
    
    public DataSource(
            String driver, 
            String url, 
            String username, 
            String password) throws Exception {
        Class.forName(driver);
        con = DriverManager.getConnection(url, username, password);
    }
    
    
    public Connection getConnection() throws Exception {
        return this.con;
    }
}
