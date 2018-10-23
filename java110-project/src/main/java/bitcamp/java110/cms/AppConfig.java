package bitcamp.java110.cms;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages="bitcamp.java110.cms")
@PropertySource("classpath:/bitcamp/java110/cms/conf/jdbc.properties")
@MapperScan("bitcamp.java110.cms.dao")
public class AppConfig {
    
    @Autowired
    Environment env;
    
    public AppConfig() {
        System.out.println("AppConfig() 호출됨!");
    }
    
    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        System.out.println("DataSource 객체 생성!");
        
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driver"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        ds.setDefaultAutoCommit(false);
        
        return ds;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(
            DataSource dataSource,
            ApplicationContext appCtx) {
        System.out.println("SqlSessionFactory 객체 생성!");
        
        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            
            // DB 커넥션풀을 관리해주는 객체를 꼽는다.
            factory.setDataSource(dataSource);
            
            // SQL 맵퍼 파일에서 도메인 객체의 별명을 사용하려면 
            // 도메인 객체가 들어 있는 패키지를 지정해야 한다. 
            // 그러면 Mybatis가 해당 패키지의 모든 클래스에 대해 별명을 자동으로 생성할 것이다.
            factory.setTypeAliasesPackage("bitcamp.java110.cms.domain");
            
            // SQL 맵퍼 파일 경로를 등록한다.
            factory.setMapperLocations(appCtx.getResources(
                    "classpath:/bitcamp/java110/cms/mapper/**/*.xml"));
            
            return factory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e); 
        }
    }
    
/*
    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        System.out.println("------------------------------");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        
        System.out.println("------------------------------");
        
        
        ManagerService s = 
                (ManagerService) iocContainer.getBean(ManagerService.class);
        System.out.println(s.list(1, 5));
        
        
        Properties props = System.getProperties();
        Set<Entry<Object,Object>> entrySet = props.entrySet();
        for (Entry entry : entrySet) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue()); 
        }
    } 
*/
}














