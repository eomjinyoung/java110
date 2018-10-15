// Mybatis - order by에서 #{} 사용
package ex04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02_1 { 

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
        
        // order by 구문에서 asc/desc는 값이 아니라 SQL이기 때문에 
        // #{} 으로 설정할 수 없다.
        params.put("sort", "desc");
        
        List<Member> list = memberDao.findAll(params);
        
        for (Member m : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    m.getNo(), m.getName(), m.getEmail(), m.getTel());
        }
        
        
        
    }

}










