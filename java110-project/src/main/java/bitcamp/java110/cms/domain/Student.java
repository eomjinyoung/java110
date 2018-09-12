package bitcamp.java110.cms.domain;

public class Student extends Member {
    private static final long serialVersionUID = 1L;
    
    protected String school;
    protected boolean working;
    protected String tel;
    
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public boolean isWorking() {
        return working;
    }
    public void setWorking(boolean working) {
        this.working = working;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}