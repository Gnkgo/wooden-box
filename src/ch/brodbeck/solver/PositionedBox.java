package ch.brodbeck.solver;

public class PositionedBox {

    private Point position;
    private Box box;

    public PositionedBox(Point position, Box box) {
        this.position = position;
        this.box = box;
    }

    public Box getPlainBox() {
        return box;
    }

    public Point getPlainPoint() {
        return position;
    }

    public boolean collidesWith(PositionedBox other) {
        int givenMaxX = position.getX() + box.getWidth();
        int givenMaxY = position.getY() + box.getLength();
        int givenMaxZ = position.getZ() + box.getHeight();

        int maxX = other.position.getX() + other.box.getWidth();
        int maxY = other.position.getY() + other.box.getLength();
        int maxZ = other.position.getZ() + other.box.getHeight();

        return (position.getX() < maxX && givenMaxX > other.position.getX()) &&
                (position.getY() < maxY && givenMaxY > other.position.getY()) &&
                (position.getZ() < maxZ && givenMaxZ > other.position.getZ());
    }

    @Override
    public String toString() {
        return "Position: " + position + " " + box;
    }
}
