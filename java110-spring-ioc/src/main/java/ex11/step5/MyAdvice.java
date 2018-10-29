package ex11.step5;

// advice 클래스
// - pointcut이 가리키는 메서드가 호출될 때
//   그 호출 전/후에 실행될 메서드를 갖고 있는 클래스이다.
//
public class MyAdvice {

    public void before() {
        System.out.println("MyAdvice.before()");
    }
    
    public void after() {
        System.out.println("MyAdvice.after()");
    }
    
    public void afterReturning() {
        System.out.println("MyAdvice.afterReturning()");
    }
    
    public void afterThrowing() {
        System.out.println("MyAdvice.afterThrowing()");
    }
    
    
}
