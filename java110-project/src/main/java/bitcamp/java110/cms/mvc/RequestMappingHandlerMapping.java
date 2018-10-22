package bitcamp.java110.cms.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.springframework.stereotype.Component;

// 클라이언트의 요청 URL과 그 요청을 처리하는 메서드 정보를 관리한다.
@Component
public class RequestMappingHandlerMapping {
    
    public static class Handler {
        public Method method;
        public Object instance;
        
        public Handler(Method m, Object o) {
            method = m;
            instance = o;
        }
    }
    
    HashMap<String,Handler> handlerMap = new HashMap<>();
    
    public Handler getHandler(String url) {
        return handlerMap.get(url);
    }
    
    public void addHandler(String url, Method method, Object instance) {
        handlerMap.put(url, new Handler(method, instance));
    }
}








