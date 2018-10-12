package ex01;

import java.util.List;

public class Test01 {

    public static void main(String[] args) throws Exception {
        DataSource ds = new DataSource(
            "org.mariadb.jdbc.Driver",
            "jdbc:mariadb://localhost:3306/studydb",
            "study",
            "1111");
        MemberDao memberDao = new MemberDao();
        memberDao.setDataSource(ds);
        
        List<Member> list = memberDao.findAll();
        
        for (Member m : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    m.getNo(), m.getName(), m.getEmail(), m.getTel());
        }
    }

}










