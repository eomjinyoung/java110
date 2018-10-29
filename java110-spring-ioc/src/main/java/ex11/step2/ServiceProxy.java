package ex11.step2;

public class ServiceProxy implements Service {
    
    Service original;
    
    public ServiceProxy(Service original) {
        this.original = original;
    }
    
    @Override
    public void add() {
        // step1에서는 add() 메서드 앞/뒤에 직접 코드를 삽입하였다.
        // step2에서는 다음과 같이 프록시 클래스에 코드를 삽입한다.
        System.out.println("ServiceProxy: Service.add() 호출 전에 해야할 일!");
        
        // 즉 다음과 같이 원래의 클래스는 손대지 않는다.
        original.add();
        
        System.out.println("ServiceProxy: Service.add() 호출 후에 해야할 일!");
    }
}
