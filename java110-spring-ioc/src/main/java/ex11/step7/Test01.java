// AOP : 애노테이션으로 AOP 설정하기 
// 
package ex11.step7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    public static void main(String[] args) {
         
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step7/app-context-1.xml");
        
        // IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        
        int r = proxy.addPhoto("ok.jpeg");
        System.out.println("리턴 값: " + r);
        
        r = proxy.addPhoto(null);
        System.out.println("리턴 값: " + r);
        
    }
    
    public static void printObjectList(ApplicationContext iocContainer) {
        System.out.println("-----------------------------");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        System.out.println("-----------------------------");
    }

}









