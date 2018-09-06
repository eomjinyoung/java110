package bitcamp.java110.cms.util;

public class LinkedList<T> {
    
    private Node<T> first;
    private Node<T> last;
    private int length;
    
    public LinkedList() {
        first = last = new Node<>();
    }
    
    public void add(T obj) {
        last.value = obj;
        Node<T> node = new Node<>();
        node.prev = last;
        last.next = node;
        last = node;
        length++;
    }
    
    public T get(int index) {
        if (index < 0 || index >= length) 
            return null;
        
        Node<T> cursor = first;
        
        for (int count = 0; count < index; count++) {
            cursor = cursor.next;
        }
        return cursor.value;
    }
    
    public T remove(int index) {
        return null;
    }
    
    public void insert(int index, T obj) {
        
    }
    
    public int size() {
        return this.length;
    }
    
    class Node<T2> {
        T2 value;
        Node<T2> next;
        Node<T2> prev;
        
        public Node() {}
        
        public Node(T2 value, Node<T2> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}


















