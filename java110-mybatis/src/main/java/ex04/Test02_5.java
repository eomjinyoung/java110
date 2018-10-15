// Mybatis - order by 설정을 위해 ${} 대신 dynamic sql 사용하기
package ex04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02_5 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex04/mybatis-config-02.xml";
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
        
        // dynamic sql에서 <choose> 태그 사용하기
        params.put("sort", "name-desc");
        
        List<Member> list = memberDao.findAll(params);
        
        for (Member m : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    m.getNo(), m.getName(), m.getEmail(), m.getTel());
        }
        
        
        
    }

}










