package ex02;

public class Engine {
    String name;
    int cc;
    int valve;

    public Engine() {}
    
    public Engine(String name, int cc, int valve) {
        super();
        this.name = name;
        this.cc = cc;
        this.valve = valve;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
    public int getValve() {
        return valve;
    }
    public void setValve(int valve) {
        this.valve = valve;
    }
    
    
}
