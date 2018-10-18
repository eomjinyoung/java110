package ex05;

public class Tire {
    private String maker;
    private int width;
    private int height;
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Tire [maker=" + maker + ", width=" + width + ", height=" + height + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + height;
        result = prime * result + ((maker == null) ? 0 : maker.hashCode());
        result = prime * result + width;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tire other = (Tire) obj;
        if (height != other.height)
            return false;
        if (maker == null) {
            if (other.maker != null)
                return false;
        } else if (!maker.equals(other.maker))
            return false;
        if (width != other.width)
            return false;
        return true;
    }
    
    
    
}
