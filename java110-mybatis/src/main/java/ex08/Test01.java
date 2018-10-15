// fk 컬럼으로 지정된 값 가져오기 - 첨부 파일 가져오기 I
package ex08;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex08/mybatis-config-01.xml";
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
        
        Member m = board.getMember();
        System.out.printf("작성자 이름:%s\n", m.getName());
        System.out.printf("작성자 이메일:%s\n", m.getEmail());
        System.out.printf("작성자 전화:%s\n", m.getTel());
        
        // 첨부 파일을 가져올 때 별도로 select를 실행한다.
        List<AttachFile> files = boardDao.findAttachFiles(board.getNo());
        
        System.out.println("첨부파일:");
        for (AttachFile f : files) {
            System.out.printf("- %s(%d)\n", f.getFilename(), f.getNo());
        }
        
    }

}










