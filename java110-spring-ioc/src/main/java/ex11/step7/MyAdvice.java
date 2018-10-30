package ex11.step7;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Before("execution(* ex11.step7.ServiceImpl.*(..)) and args(f)")
    public void before(String f) {
        System.out.println("MyAdvice.before(): " + f);
    }
    
    @AfterReturning(
        pointcut="execution(* ex11.step7.ServiceImpl.*(..))",
        returning="rt")
    public void afterReturning(Object rt) {
        System.out.println("MyAdvice.afterReturning(): " + rt.toString());
    }
    
    @AfterThrowing(
        pointcut="execution(* ex11.step7.ServiceImpl.*(..))",    
        throwing="err")
    public void afterThrowing(Exception err) {
        System.out.println("MyAdvice.afterThrowing(): " + err.getMessage());
    }
    
    
}










