// setter 호출 : 의존 객체 주입 순서
// => 의존 객체를 먼저 생성할 필요가 없다.
// => 스프링 IoC 컨테이너가 자동으로 처리한다.
// 
package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {

    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex05/app-context-6.xml");
        
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
        
        //Car c1 = (Car)iocContainer.getBean("c1");
        //System.out.println(c1);
        
        //Car c2 = (Car)iocContainer.getBean("c2");
        //System.out.println(c2);
    }
}









