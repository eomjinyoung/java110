package bitcamp.java110.cms;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="bitcamp.java110.cms")
public class AppConfig {
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        try {
            String resource = "bitcamp/java110/cms/conf/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            return new SqlSessionFactoryBuilder().build(inputStream);
            
        } catch (Exception e) {
            throw new RuntimeException(e); 
        }
    }
}
