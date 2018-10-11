package bitcamp.java110.ex13;

import bitcamp.java110.Member;

public class Inventory2 {
    // Member 객체를 각 Thread의 변수로 만든다.
    ThreadLocal<Member> myLocal = new ThreadLocal<>();

    public Member getMember() {
        return myLocal.get();
    }

    public void setMember(Member member) {
        this.myLocal.set(member);
    }
}
