// fk 컬럼으로 지정된 값 가져오기 - join하여 가져오기
package ex06;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex06/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        Board board = boardDao.findByNo(1);
        System.out.printf("번호:%d\n", board.getNo());
        System.out.printf("제목:%s\n", board.getTitle());
        System.out.printf("내용:%s\n", board.getContent());
        System.out.printf("조회수:%d\n", board.getViewCount());
        System.out.printf("등록일:%s\n", board.getCreatedDate());
        
        // 게시물 상세조회할 때 작성자의 정보 또한 자세히 출력하는 상황:
        // => ex05에서와 달리 작성자의 상세 정보를 가져오기 위해 
        //    p1_memb 테이블에 대해 따로 select를 하지 않는다.
        // => 게시물을 가져올 때 join 해서 작성자 정보까지 가져온다.
        // => 단 게시물에 작성자 정보도 담아야 하기 때문에 
        //    Board 테이블에 email과 tel 필드를 추가해야 한다.
        // => 목록에서 간단히 name을 추가하는 경우와 달리
        //    Board 클래스에 작성자의 대대분의 정보를 저장할 
        //    필드 추가해야 한다.
        // => 이것은 객체지향의 중요한 특징 중 하나인 
        //    "High Cohesion(높은 응집력; 한 클래스 한 역할)"을 어기는 것이다.
        ///   한 클래스가 여러 역할을 맡으면 유지보수가 어려워진다.
        // => 즉 p1_memb 테이블에 변경이 발생하면 
        //    Member 클래스 외에 Board 클래스도 영향을 받는 것이 문제이다.
        // => 해결책?
        //    ex07을 보라!
        System.out.printf("작성자 이름:%s\n", board.getWriter());
        System.out.printf("작성자 이메일:%s\n", board.getEmail());
        System.out.printf("작성자 전화:%s\n", board.getTel());
        
    }

}










