package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    Connection con;
    
    public Connection getConnection() throws Exception {
        
        if (con == null) {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
        }
        
        return this.con;
    }
}
