// 의존 객체 자동 주입 : @Autowired에서 같은 타입의 객체가 여러 개일 때 II
// => @Qualifier를 사용하여 객체의 이름을 지정한다.
//
package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex08/app-context-5.xml");
        
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
        
        Car3 c1 = (Car3)iocContainer.getBean("c1");
        System.out.println(c1);
        
        
    }

}









