package bitcamp.java110.cms.util;

public interface List<T> {
    void add(T obj);
    T get(int index);
    T remove(int index);
    int size();
    
    // default의 목적
    // => 규칙을 추가하면 기존 클래스들이 영향을 받는다.
    // => 즉 기존 클래스들은 새로 추가한 메서드를 반드시 구현해야 한다.
    // => 이런 문제를 해결하기 위해 등장한 문법이다.
    // => 기존 클래스들에 영향을 주지 않게 해주는 문법이다.
    default void insert(int index, T obj) {
        // 인터페이스의 메서드는 규칙이다.
        // 하위 호환을 위해서 메서드를 추가하고 구현하더라도 
        // 실제 많은 작업을 처리하게 구현해서는 안된다.
        // 구현 클래스들에 영향을 끼치지 않게 하는 정도만 코드를 작성해야 한다.
    }
}
