// 메서드 호출 앞 또는 뒤에 코드 붙이기 : 프록시 클래스 자동 생성하기 
// 
package ex11.step3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test02 {

    public static void main(String[] args) {
        
        HashMap<String,Object> original = new HashMap<>();

        // HashMap의 프록시를 만들기
        // => 자바에서 제공하는 Proxy 생성기를 통해 만든다.
        Map<String,Object> map = createProxy(original);
        
        map.put("name", "홍길동");
        map.put("Name", "임꺽정");
        map.put("naMe", "유관순");
        
        System.out.println(map.get("name"));
        System.out.println(map.get("Name"));
        System.out.println(map.get("naMe"));
        
        
    }
    
    @SuppressWarnings({ "unused", "unchecked" })
    private static  Map<String,Object> createProxy(
                Map<String,Object> original) {
        
        return (Map<String,Object>) Proxy.newProxyInstance(
                original.getClass().getClassLoader(), 
                new Class[] {Map.class},
                // 맵에 값을 저장할 때마다 충고할 필터 객체 생성
                new Advice(original));
    }
    
    static class Advice implements InvocationHandler {
        Map<String,Object> original;
        
        public Advice(Map<String,Object> original) {
            this.original = original;
        }
        
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // get()/put() 메서드가 호출될 때 
            // 기존 key를 소문자 key로 교체한다.
            if (method.getName().equals("get") ||
                method.getName().equals("put")) {
                String key = (String)args[0];
                args[0] = key.toLowerCase();
            }
            
            return method.invoke(original, args);
        }
        
    }

}









