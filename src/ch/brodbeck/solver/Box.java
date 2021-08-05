package ch.brodbeck.solver;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Box {

    private int length; //attribute x
    private int width; //test y
    private int height; // z

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public Set<Box> getAllRotations() {
        Set<Box> hashSet = new HashSet<>();
        hashSet.add(new Box(length, width, height));
        hashSet.add(new Box(length, height, width));
        hashSet.add(new Box(height, width, length));
        hashSet.add(new Box(height, length, width));
        hashSet.add(new Box(width, height, length));
        hashSet.add(new Box(width, length, height));
        return hashSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return length == box.length && width == box.width && height == box.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, height);
    }

    @Override
    public String toString() {
        return "Box{"+ "height=" + height + ", width=" + width + ", length=" + length +"}";
    }
}
