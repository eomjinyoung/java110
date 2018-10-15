// Mybatis - <foreach> 태그 사용법
package ex04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03_2 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex04/mybatis-config-03.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        MemberDao memberDao = new MemberDao();
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        // 페이징 처리
        int pageNo = 1;
        int pageSize = 100;
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("rowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        // <foreach>를 사용하면 목록 데이터 개수 만큼 반복해서 SQL을 생성할 수 있다.
        // 생성할 SQL 문:
        //      name in ('user01', 'user03', 'm100')
        //
        params.put("names", new String[] {"user01", "user03", "m100"});
        
        List<Member> list = memberDao.findAll(params);
        
        for (Member m : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    m.getNo(), m.getName(), m.getEmail(), m.getTel());
        }
        
        
        
    }

}










