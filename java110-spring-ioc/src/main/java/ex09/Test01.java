// 객체 생성 : 애노테이션으로 설정하기
// => XML <bean> 태그 대신에 애노테이션을 이용하여 객체를 생성할 클래스를 지정할 수 있다.
//    클래스 선언부에 붙이면 된다.
// => 애노테이션 
//      @Component
// => 스프링은 객체의 역할에 따라 구분할 수 있도록 다음의 애노테이션을 추가로 제공한다.
//      @Controller : MVC 구조에서 컨트롤러 역할을 하는 클래스를 가리킨다.
//      @Service    : 비즈니스 로직을 수행하는 클래스를 가리킨다.
//      @Repository : DAO 처럼 데이터를 처리하는 클래스를 가리킨다.
//      @RestController : RESTful 서비스를 처리하는 컨트롤러를 가리킨다.
// 
// => 물론 @Autowired의 경우처럼 
//    이 애노테이션을 처리할 객체를 스프링 IoC 컨테이너에 추가해야 한다.
//    다음의 태그를 사용하면 관련 객체가 자동으로 추가된다.
//
//        <context:component-scan base-package="패키지명"/>
// 
//    이 태그는 <context:annotation-config> 의 기능도 포함하기 때문에 
//    이 태그를 작성하면 <context:annotation-config> 태그는 제거해도 된다.
// 
package ex09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex09/app-context-1.xml");
        
        System.out.println("------------------------------");
        
        // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        
        System.out.println("------------------------------");
        
        Car c1 = (Car)iocContainer.getBean("c1");
        System.out.println(c1);
        
        
    }

}









