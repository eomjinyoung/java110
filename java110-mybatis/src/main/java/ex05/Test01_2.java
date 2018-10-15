// fk 컬럼으로 지정된 값 가져오기 - select를 별도로 실행하여 가져오기
package ex05;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01_2 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex05/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        MemberDao memberDao = new MemberDao();
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("rowNo", 0);
        params.put("pageSize", 5);
        
        List<Board> boards = boardDao.findAll(params);
        for (Board b : boards) {
            Member member = memberDao.findByNo(b.getMemberNo());

            System.out.printf("%d, %s, %d, %s, %s\n", 
                    b.getNo(),
                    b.getTitle(),
                    b.getViewCount(),
                    member.getName(),
                    b.getCreatedDate());
        }
        
        // 그러나 게시물 목록조회에서 작성자의 이름을 출력하기 위해 
        // 각 게시물에 대해 매번 select를 실행한다면 
        // 그것은 DBMS에 오버헤드를 발생시켜 성능을 저하시키는 원인이 된다.
        // 해결책?
        // => 조인을 이용하라!
    }

}










