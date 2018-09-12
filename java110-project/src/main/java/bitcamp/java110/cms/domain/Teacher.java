package bitcamp.java110.cms.domain;

public class Teacher extends Member {
    private static final long serialVersionUID = 1L;
    
    protected String tel;
    protected int pay;
    protected String subjects;
    
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public int getPay() {
        return pay;
    }
    public void setPay(int pay) {
        this.pay = pay;
    }
    public String getSubjects() {
        return subjects;
    }
    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
