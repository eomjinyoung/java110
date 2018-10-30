package ex11.step6;

// 원래 메서드에 넘어갈 파라미터 값과
// 원래 메서드가 리턴하는 값을 알아내기
//
public class MyAdvice {

    // advice의 메서드에서 호출될 메서드의 값을 미리 받아보려면 
    // 다음과 같이 설정해야 한다.
    // 
    // <aop:before method="before" 
    //    pointcut="execution(* ex11.step6.ServiceImpl.addPhoto(..)) and args(f)"/>
    // 
    public void before(String f) {
        System.out.println("MyAdvice.before(): " + f);
    }
    
    // advice의 메서드에서 호출된 메서드의 리턴 값을 확인하고 싶다면,
    // 다음과 같이 설정해야 한다.
    //
    // <aop:after-returning method="afterReturning"
    //      pointcut="execution(* ex11.step6.ServiceImpl.addPhoto(..))"
    //      returning="rt"/>
    //
    public void afterReturning(Object rt) {
        System.out.println("MyAdvice.afterReturning(): " + rt.toString());
    }
    
    // advice의 메서드에서 호출된 메서드의 예외 정보를 확인하고 싶다면,
    // 다음과 같이 설정해야 한다.
    //
    // <aop:after-throwing method="afterThrowing"
    //      pointcut="execution(* ex11.step6.ServiceImpl.addPhoto(..))"
    //      throwing="err"/>
    //
    public void afterThrowing(Exception err) {
        System.out.println("MyAdvice.afterThrowing(): " + err.getMessage());
    }
    
    
}










