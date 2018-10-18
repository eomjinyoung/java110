// setter 호출 : p 네임스페이스
// 
// XML 문법
// 방법)
//      <bean id="아이디" class="클래스명"
//            p:프로퍼티명="값" p:프로퍼티명-ref="객체"/>
// 
// 단 <beans> 태그에 p 네임스페이스를 선언해야 한다.
// p 네임스페이스는 XML Schema 파일의 URL을 지정할 필요가 없다.
// 
package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex05/app-context-5.xml");
        
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









