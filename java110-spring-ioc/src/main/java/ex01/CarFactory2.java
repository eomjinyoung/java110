package ex01;

import java.sql.Date;

public class CarFactory2 {
    
    public Car create(String model) {
        Car c = new Car();
        
        switch (model) {
        case "티코":
            c.setModel("Tico");
            c.setCc(890);
            c.setMaker("대우자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;
        case "소나타":
            c.setModel("Sonata");
            c.setCc(1980);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;
        case "그랜저":
            c.setModel("Grandeur");
            c.setCc(1980);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;
        default:
            c.setModel("Avante");
            c.setCc(1500);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
        }
        return c;
    }
}










