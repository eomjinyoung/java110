package ex11.step4;

// advice 클래스
// - pointcut이 가리키는 메서드가 호출될 때
//   그 호출 전/후에 실행될 메서드를 갖고 있는 클래스이다.
//
public class MyAdvice {

    public void advice1() {
        System.out.println("MyAdvice.advice1()");
    }
    
    public void advice2() {
        System.out.println("MyAdvice.advice2()");
    }
}
