package ex06;

import org.springframework.beans.factory.FactoryBean;

// 스프링 프레임워크의 규칙에 따라 공장 클래스 만들기
// => FactoryBean 인터페이스를 구현해야 한다.
//
public class EngineFactory3 implements FactoryBean<Engine> {
    
    String model;
    
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("EngineFactory3.getObjectType()");
        // 공장에서 생산하는 객체의 타입을 알려주기 위해 리턴한다.
        // 스프링 IoC 컨테이너는 공장을 통해 객체를 생성하기 전에
        // 이 메서드를 먼저 호출하여 타입을 알아낼 것이다.
        return Engine.class;
    }
    
    @Override
    public Engine getObject() throws Exception {
        System.out.println("EngineFactory3.getObject()");
        // 스프링 IoC 컨테이너는 객체를 생성할 때 
        // 이 메서드를 호출할 것이다. 
        
        Engine e = new Engine();
        
        switch (this.model) {
        case "B100":
            e.setMaker("비트자동차");
            e.setValve(16);
            e.setDiesel(false);
            break;
        case "B200":
            e.setMaker("비트자동차");
            e.setValve(32);
            e.setDiesel(true);
            break;
        case "H01":
            e.setMaker("현대자동차");
            e.setValve(16);
            e.setDiesel(false);
            break;
        case "HX9":
            e.setMaker("현대자동차");
            e.setValve(32);
            e.setDiesel(true);
            break;
        default:
            e.setMaker("오호라자동차");
            e.setValve(8);
            e.setDiesel(false);
        }
        
        return e;
    }
}








