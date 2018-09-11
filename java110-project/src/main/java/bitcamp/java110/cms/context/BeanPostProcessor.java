package bitcamp.java110.cms.context;

// 이 규칙은 
// IoC 컨테이너(ApplicationContext)가 객체들을 생성한 후에
// 마무리 작업을 수행하는 객체에 대해 호출하는 규칙이다.
// 따라서 마무리 작업을 수행하는 클래스를 만들 때는 
// 반드시 다음 규칙을 준수해야 한다.
// 
public interface BeanPostProcessor {
    void postProcess(ApplicationContext beanContainer);
}
