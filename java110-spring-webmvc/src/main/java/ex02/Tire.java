package ex02;

public class Tire {
    String name;
    int radius;
    
    public Tire() {}
    
    public Tire(String name, int radius) {
        super();
        this.name = name;
        this.radius = radius;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
}
