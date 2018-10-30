// Spring WebMVC 설정을 다루는 클래스
package bitcamp.java110.cms.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import bitcamp.java110.cms.web.interceptor.AuthInterceptor;

// 이 클래스가 IoC 컨테이너가 사용해야 할 설정 정보를 담고 있는 클래스임을
// 프론트 컨트롤러에게 알려주기 위해서는 다음 애노테이션을 반드시 붙여야 한다.
@Configuration

// 다음 애노테이션을 붙이면 <mvc:annotation-driven/> 설정과 같은 의미이다.
// mvc 관련 설정을 활성화시킨다.
@EnableWebMvc
public class WebConfig
    // 만약 MVC 설정을 좀 더 세밀하게 제어하고 싶다면 다음 인터페이스를 구현하라!
    implements WebMvcConfigurer {

    public WebConfig() {
        System.out.println("WebConfig() 호출됨!");
    }
    
    // 인터페이스의 모든 메서드를 당장 구현할 필요가 없다.
    // 설정하고 싶은 메서드만 찾아서 구현하라!
    
    // 인터셉터를 설정하고 싶다면 다음 메서드를 구현하라!
    // => 이 메서드를 프론트 컨트롤러가 호출하여 인터셉터를 관리할 것이다.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 추가하고픈 인터셉터를 등록기(registry)에 추가하라!
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**/add", "/**/delete");
    }
}












