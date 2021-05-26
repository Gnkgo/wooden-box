package ch.brodbeck.solver;
import org.junit.Assert;
import org.junit.Test;

public class PositionedBoxTest {
    @Test
    public void checkCollisionTest() {

        PositionedBox a = new PositionedBox(new Point(0,0,0), new Box(3,3,3));
        PositionedBox b = new PositionedBox(new Point(2,2,2), new Box(4, 3, 1));
        Assert.assertTrue(a.collidesWith(b));

        a = new PositionedBox(new Point(3,4,4), new Box(3,3,3));
        b = new PositionedBox(new Point(4,4,4), new Box(4, 3, 1));
        Assert.assertTrue(a.collidesWith(b));

        a = new PositionedBox(new Point(0,0,0), new Box(3,3,3));
        b = new PositionedBox(new Point(4,4,4), new Box(4, 4, 4));
        Assert.assertFalse(a.collidesWith(b));

        a = new PositionedBox(new Point(0,0,0), new Box(3,3,3));
        b = new PositionedBox(new Point(3,3,3), new Box(4, 4, 4));
        Assert.assertFalse(a.collidesWith(b));
    }
}
