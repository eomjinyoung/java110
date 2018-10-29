// 메서드 호출 앞 또는 뒤에 코드 붙이기 : 직접 코드 삽입이 불가능한 경우? 
// 
package ex11.step1;

import java.util.HashMap;
import java.util.Map;

public class Test02 {

    public static void main(String[] args) {
        test1();
        System.out.println("--------------------");
        
        test2();
        System.out.println("--------------------");
        
        test3();
    }
    
    // 대소문자를 구분하는 key : 원래의 Map에서 사용하는 key는 대소문자를 구분한다.
    public static void test1() {
        Map<String,Object> map = new HashMap<String,Object>();
        
        map.put("name", "홍길동");
        map.put("Name", "임꺽정");
        map.put("naMe", "유관순");
        
        System.out.println(map.get("name"));
        System.out.println(map.get("Name"));
        System.out.println(map.get("naMe"));
        
    }
    
    // key를 대소문자를 구분하지 않게 하고 싶다
    // => get(), put() 호출 전에 대소문자를 구분하지 않는 코드를 삽입하라!
    public static void test2() {
        Map<String,Object> map = new HashMap<String,Object>();
        
        map.put("name".toLowerCase(), "홍길동");
        map.put("Name".toLowerCase(), "임꺽정");
        map.put("naMe".toLowerCase(), "유관순");
        
        System.out.println(map.get("name".toLowerCase()));
        System.out.println(map.get("Name".toLowerCase()));
        System.out.println(map.get("naMe".toLowerCase()));
        
        // 이 방식의 문제는, 
        // 대소문자를 구분하지 않는 맵을 사용하려면, 
        // 위와 같은 식으로 get(), put() 할 때마다
        // key에 대해 toLowerCase()를 호출해야 한다는 불편함이 있다.
        
    }
    
    // key에 대해 대소문자를 구분하지 않게 Map을 만드는 두 번째 방법:
    // => 기존 맵을 상속 받아 기능을 변경하는 것이다.
    public static void test3() {
        
        // 기존의 Map 소스를 변경할 수 없기 때문에, 
        // 기존 클래스를 상속 받아 기능을 변경해야 한다.
        
        class MyHashMap extends HashMap<String,Object> {
            // get()과 put()의 기능을 재정의 한다. (오버라이딩)
            @Override
            public Object put(String key, Object value) {
                return super.put(key.toLowerCase(), value);
            }
            
            @Override
            public Object get(Object key) {
                String key2 = (String)key;
                return super.get(key2.toLowerCase());
            }
        }
        
        
        Map<String,Object> map = new MyHashMap();
        
        map.put("name", "홍길동");
        map.put("Name", "임꺽정");
        map.put("naMe", "유관순");
        
        System.out.println(map.get("name"));
        System.out.println(map.get("Name"));
        System.out.println(map.get("naMe"));
        
        
        // 상속으로 기능을 변경하는 방식의 문제점?
        // => 다른 클래스(예: Hashtable)에도 적용하고 싶다면 
        //    또 그 클래스를 상속 받아 새 클래스를 만들어야 한다.
    }

}









