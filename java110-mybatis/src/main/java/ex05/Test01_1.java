// fk 컬럼으로 지정된 값 가져오기 - select를 별도로 실행하여 가져오기
package ex05;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01_1 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex05/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        MemberDao memberDao = new MemberDao();
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        
        Board board = boardDao.findByNo(1);
        System.out.printf("번호:%d\n", board.getNo());
        System.out.printf("제목:%s\n", board.getTitle());
        System.out.printf("내용:%s\n", board.getContent());
        System.out.printf("조회수:%d\n", board.getViewCount());
        System.out.printf("등록일:%s\n", board.getCreatedDate());
        
        // 게시물 상세조회 같이 한 개의 데이터를 가져올 때는 
        // 다음과 같이 작성자의 정보를 가져오기 위해 
        // 별도로 select를 실행해도 된다.
        
        Member member = memberDao.findByNo(board.getMemberNo());
        System.out.printf("작성자:%s(%s)\n", 
                member.getName(), member.getEmail());
        
    }

}










