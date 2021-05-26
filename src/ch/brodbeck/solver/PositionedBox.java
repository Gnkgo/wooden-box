package ch.brodbeck.solver;

public class PositionedBox {

    private Point position;
    private Box box;

    public PositionedBox(Point position, Box box) {
        this.position = position;
        this.box = box;
    }

    public boolean collidesWith(PositionedBox other) {
        // TODO: Implement code here
        return false;
    }

}
