package ex11.step3;

import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ex11.step3")
public class AppConfig {
    
    // 메서드 파라미터에 ApplicationContext 타입의 변수를 선언하면,
    // IoC 컨테이너는 이 메서드를 호출할 때 자신의 주소를 넘겨준다.
    @Bean
    public Object service(ApplicationContext iocContainer) {
        
        // IoC 컨테이너의 원래 타입으로 형변환 한다.
        // 왜? ApplicationContext에는 객체를 조회하는 메서드만 있다.
        // 원래의 IoC 컨테이너 클래스에는 객체를 추가하고 제거하는 메서드도 있다.
        // 
        AnnotationConfigApplicationContext iocContainer2 = 
                (AnnotationConfigApplicationContext)iocContainer;
        
        // 현재 IoC 컨테이너에 들어 있는 객체 목록 출력하기
        printObjectList(iocContainer);
        
        // 기존의 Service 구현체를 꺼낸다.
        Service original = iocContainer.getBean(Service.class);
        
        // IoC 컨테이너에서 기존 객체를 제거한다.
        // => 먼저 제거할 객체의 이름을 알아낸다.
        String[] names = iocContainer.getBeanNamesForType(Service.class);
        // => 해당 이름의 객체를 삭제한다.
        for (String name : names) {
            iocContainer2.removeBeanDefinition(name);
        }
        
        // 기존의 Service 구현체를 가지고 프록시 객체를 만든다.
        // => 메서드 필터 객체 생성
        MethodFilter filter = new MethodFilter(original);
        
        // => 프록시 객체 만들기
        Service serviceProxy = (Service) Proxy.newProxyInstance(
                // 원래 객체의 클래스 로더 
                original.getClass().getClassLoader(),
                
                // 원래 객체가 구현한 인터페이스들의 타입 정보
                new Class[] {Service.class}, 
                
                // 프록시의 메서드를 호출할 때 마다 실행될 필터 객체 
                filter);
        
        return serviceProxy;
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
    }
}










