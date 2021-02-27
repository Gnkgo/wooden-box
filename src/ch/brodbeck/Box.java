package ch.brodbeck;

//import java.lang.annotation.Target;

public class Box {
    private int length; //attribute
    private int width;
    private int height;
    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public int volume() {
        return length * width * height;
    }
}
