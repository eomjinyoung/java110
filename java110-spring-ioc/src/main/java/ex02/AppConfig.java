package ex02;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig() 호출됨!");
    }
    
    @Bean // <== 빈 컨테이너에게 이 메서드를 호출해서 리턴 값을 보관하라는 명령
    public Car getCar() {
        System.out.println("getCar() 호출됨!");
        Car c = new Car();
        c.setModel("소나타");
        c.setCc(1998);
        c.setMaker("현대자동차");
        return c;
    }
}
