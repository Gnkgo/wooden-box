package ch.brodbeck;

public class Box {
    public int length; //attribute
    public int width;
    public int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public int volume() {
        return length * width * height;
    }
    public int getLength() {
        return length;
    }
    public int getWidth() { return width; }
    public int getHeight() {
        return height;
    }
}
