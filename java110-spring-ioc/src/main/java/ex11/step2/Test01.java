// 메서드 호출 앞 또는 뒤에 코드 붙이기 : 프록시 패턴을 적용하여 처리하기
// 
package ex11.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {

    public static void main(String[] args) {
         
        ApplicationContext iocContainer = 
                //new ClassPathXmlApplicationContext("ex11/step1/app-context.xml");
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
        
        
        // 만약 Service 클래스의 add() 메서드 호출 앞/뒤로 뭔가 다른 일을 수행하고 싶다면?
        // 1) 기존 클래스를 손대지 말아야 하는 경우,
        //    즉 이미 다른 프로젝트에서 기존 클래스를 사용하고 있을 때!
        //    
        // 2) 기존 클래스의 소스 코드가 없어서 손댈 수 없는 상황이라면?
        //    즉 직접 만든 클래스가 아니라 외부 라이브러리에 들어 있는 클래스를 사용할 때!
        //
        // => 프록시 패턴을 적용한다.
        // => 즉 기존 클래스와 똑 같은 규칙으로 클래스를 만든다.
        //    그리고 그 클래스를 기존 클래스처럼 사용한다.
        //    이 클래스를 "프록시(proxy)"라고 부른다.
        // => 프록시 클래스를 정의했으면 기존 클래스를 사용하는 대신에 
        //    프록시 객체를 만들어 사용한다.
        //    다만 프록시를 호출하면 프록시는 기존 클래스의 메서드를 호출하는 방식으로 
        //    동작한다.
        
        // IoC 컨테이너가 리턴하는 것은 ServiceProxy 객체이다.
        Service caller = (Service)iocContainer.getBean(Service.class);
        caller.add();
        
        // 이 방법의 문제점!
        // => 개발자가 직접 Proxy 클래스를 정의해야 한다.
        // => 만약 오버라이딩 할 메서드가 수십 개일 경우 
        //    프록시 클래스를 만들 때 그 메서드를 모두 오버라이딩 해야 하는 부담이 있다.
        // 
        // 해결책!
        // => 자바에서는 제공하는 Proxy 자동 생성기를 이용한다!  
        
        
    }

}









