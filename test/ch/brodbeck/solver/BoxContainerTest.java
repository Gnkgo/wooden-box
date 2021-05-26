package ch.brodbeck.solver;

import org.junit.Assert;
import org.junit.Test;

public class BoxContainerTest {
    @Test
    public void testFindPlace() {
        BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
        Box a = new Box(3, 3, 3);
        Box b = new Box(4, 4, 4);
        Point position = boxContainer.findPosition(a);
        Assert.assertEquals(new Point(0, 0, 0), position);

        boxContainer.placeBox(a,position);
        position = boxContainer.findPosition(b);
        Assert.assertEquals(new Point(3,0,0), position);
    }
}
