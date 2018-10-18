// 인스턴스 비교 II : equals() overriding 후
// 
package ex05;

public class Test02_p2 {

    static class Member {
        String name;
        int age;
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public boolean equals(Object obj) {
            // 인스턴스 필드의 값이 같을 때 true를 리턴하도록 재정의 한다.
            if (!(obj.getClass() == Member.class))
                return false;
            
            Member other = (Member) obj;
            
            if (this == other)
                return true;
            
            if (!this.name.equals(other.name) ||
                 this.age != other.age)
                return false;
            
            return true;
        }
    }
    
    public static void main(String[] args) {
        
        Member obj1 = new Member("홍길동", 20);
        Member obj2 = new Member("홍길동", 20);
        
        // 인스턴스 비교
        // 1) == 연산자는 레퍼런스에 저장된 인스턴스의 주소를 비교한다.
        if (obj1 == obj2) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");
        
        // 2) equals() 메서드를 오버라이딩 하여 두 인스턴스의 값을 비교했기 때문에 
        //    인스턴스가 다르더라도 필드의 값이 같다면 true를 리턴할 것이다.
        if (obj1.equals(obj2)) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");
        
    }

}









