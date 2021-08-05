package ch.brodbeck.solver;

import org.junit.Assert;
import org.junit.Test;

public class BoxContainerTest {
    @Test
    public void testFindPlace() {
        BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
        Box a = new Box(3, 3, 3);
        Box b = new Box(1, 1, 1);
        Box c = new Box(1, 1, 1);
        Point position = boxContainer.findPosition(a);
        Assert.assertEquals(new Point(0, 0, 0), position);

        boxContainer.placeBox(a, position);
        position = boxContainer.findPosition(b);
        Assert.assertEquals(new Point(3,0,0), position);

        boxContainer.placeBox(b, position);
        position = boxContainer.findPosition(c);
        Assert.assertEquals(new Point(4, 0, 0), position);


    }
    @Test
    public void testDeleteBox() {
        BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
        Box a = new Box(3, 3, 3);
        Box b = new Box(4, 4, 4);
        Box c = new Box(1, 1, 1);

        Point position = boxContainer.findPosition(a);
        boxContainer.placeBox(a, position);
        position = boxContainer.findPosition(b);
        boxContainer.placeBox(b, position);
        Assert.assertEquals(2, boxContainer.countBoxes());

        position = boxContainer.findPosition(c);
        boxContainer.placeBox(c, position);
        boxContainer.deleteBox();
        Assert.assertEquals(2, boxContainer.countBoxes());
    }
    @Test
    public void outOfBoxTest() {
        BoxContainer boxContainer = new BoxContainer(new Box(5, 5, 5));
        Point position = new Point(4,4,4);
        Box[] boxes = new Box[]{
                new Box(1, 1, 1),
                new Box(2, 2, 2),
                new Box(3, 3, 3),
        };
        PositionedBox positionedBox = new PositionedBox(position, boxes[1]);

        Assert.assertFalse(boxContainer.outOfBox(positionedBox));


    }
}
