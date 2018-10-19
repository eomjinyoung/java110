// Java Config 
// => XML로 설정하지 않고 자바 클래스에서 애노테이션으로 설정하는 것을 말한다.
// => 요즘 많이 사용하고 있는 SpringBoot의 기본 설정 방법이다.
//
package ex10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {

    public static void main(String[] args) {
        
        // Java Config를 사용할 때는 다음 IoC 컨테이너를 사용한다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
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
        
        Car c2 = (Car)iocContainer.getBean("getCar");
        System.out.println(c2);
        
        Car c3 = (Car)iocContainer.getBean("c3");
        System.out.println(c3);
        
        Car c4 = (Car)iocContainer.getBean("c4");
        System.out.println(c4);
    }

}









