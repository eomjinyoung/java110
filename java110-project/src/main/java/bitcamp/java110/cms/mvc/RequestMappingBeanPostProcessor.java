package bitcamp.java110.cms.mvc;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class RequestMappingBeanPostProcessor
        implements BeanPostProcessor {
    
    @Autowired
    RequestMappingHandlerMapping handlerMapping;

    @Override
    public Object postProcessAfterInitialization(
            Object bean, String beanName) throws BeansException {
        
        System.out.println("[" + beanName + "]" + 
                " RequestMappingBeanPostProcessor.postProcessAfterInitialization()");
        
        // 객체의 클래스 정보 가져오기
        Class<?> clazz = bean.getClass();
        
        // 상속 받은 메서드는 제외하고 해당 클래스에 추가하거나 오버라이딩 한 메서드 목록 얻기
        Method[] methods = clazz.getDeclaredMethods();
        
        // 메서드 중에서 @RequestMapping이 붙은 메서드를 찾는다.
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno == null) continue;
            
            // 찾았으면 애노테이션에서 URL을 추출한다.
            String url = anno.value();
            
            // url 정보와 메서드, 객체 정보를 보관한다.
            handlerMapping.addHandler(url, m, bean);
            System.out.printf("==> %s : %s\n", url, m.getName());
        }
        
        return bean;
    }

}










