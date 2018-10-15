package ex07;

import java.sql.Date;

public class Board {
    
    protected int no;
    protected String title;
    protected String content;
    protected int viewCount;
    protected Date createdDate;
    protected int memberNo;
    protected String writer; // 목록에서 작성자의 이름을 출력하기 위해 필드 추가
    
    // 이전의 ex06 패키지와 달리 작성자 정보는 Member 객체에 담는다.
    protected Member member;
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    
    
    
}
