package ex09;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 객체의 이름을 지정하지 않으면 클래스 이름이 사용된다.
// XML <bean> 태그에서 id를 생략하면 다음과 같은 이름을 갖게되지만,
//      이름: ex08.Car2#0
//      별명: ex08.Car2
// @Component 애노테이션을 사용할 때는 다음과 같은 이름을 갖는다.
//      이름: car2
//
@Component
public class Car2 {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    
    @Autowired
    private Engine engine;
    
    public Car2() {
        System.out.println("Car() 호출됨!");
    }
    
    public Car2(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(String,int) 호출됨!");
    }
    
    public Car2(int cc, String maker) {
        this.maker = maker;
        this.cc = cc;
        System.out.println("Car(int,String) 호출됨!");
    }
    
    public Car2(String model, int cc, Engine engine) {
        this.model = model;
        this.cc = cc;
        this.engine = engine;
        System.out.println("Car(String,int,Engine) 호출됨!");
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public Engine getEngine() {
        return engine;
    }


    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }

}
