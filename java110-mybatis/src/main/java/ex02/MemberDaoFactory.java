package ex02;

public class MemberDaoFactory {
    
    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    // 객체를 생성해주는 메서드
    // => "Factory Method" 설계 패턴이다.
    // => 객체 생성 과정이 복잡하거나 번거로울 경우 주로 사용한다.
    // 
    public MemberDao createMemberDao() throws Exception {
        MemberDao memberDao = new MemberDao();
        memberDao.setDataSource(dataSource);
        
        return memberDao;
    }
}
