// Mybatis - order by 설정을 위해 ${} 사용 : SQL 삽입
package ex04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02_3 { 

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
        
        // order by 설정이 SQL 문이라 #{}을 사용할 수 없다면,
        // ${}를 사용하여 SQL을 삽입하면 안되는가?
        // => 된다!
        // => 그러나 SQL 삽입은 주의해야 한다. 가능한 사용하지 말라! 
        // => 특히 사용자가 입력한 값을 SQL로 삽입하는 경우 
        //    SQL 삽입 해킹을 당할 수 있다.
        params.put("sort", "email desc");
        
        List<Member> list = memberDao.findAll(params);
        
        for (Member m : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    m.getNo(), m.getName(), m.getEmail(), m.getTel());
        }
        
        
        
    }

}










