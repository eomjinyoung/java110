package bitcamp.java110.cms.util;

public class ArrayList<T> implements List<T> {
    
    // 객별적으로 관리해야 할 값이라면 인스턴스 변수를 사용하라!
    private Object[] list = new Object[5];
    private int index = 0;
    
    public void add(T obj) {
        if (index == list.length) {
            increaseStorage();
        }
        list[index++] = obj;
    }
    
    private void increaseStorage() {
        Object[] newList = new Object[list.length + 3];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    
    public T remove(int no) {
        if (no < 0 || no >= index) {
            return null;
        }
        
        @SuppressWarnings("unchecked")
        T removedObj = (T)list[no];
        
        for (int i = no; i < index - 1; i++) {
            list[i] = list[i + 1];
        }
        index--;
        
        return removedObj;
    }
    
    public int size() {
        return index;
    }

    @SuppressWarnings("unchecked")
    public T get(int no) {
        if (no < 0 || no >= index) {
            return null;
        }
        
        return (T)list[no];
    }
    
}









