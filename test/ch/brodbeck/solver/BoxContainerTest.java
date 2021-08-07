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

        boxContainer.getPlacedBoxes().add(new PositionedBox(position, a));
        position = boxContainer.findPosition(b);
        Assert.assertEquals(new Point(3,0,0), position);

        boxContainer.getPlacedBoxes().add(new PositionedBox(position, b));
        position = boxContainer.findPosition(c);
        Assert.assertEquals(new Point(4, 0, 0), position);


    }

    @Test
    public void testRotateBox() {
        BoxContainer boxContainer = new BoxContainer(new Box(3, 5, 3));
        Box[] boxes = new Box[]{
                new Box(1, 3, 5),
                new Box(2, 3, 4),
                new Box(1, 2, 3),
        };
        Point position = boxContainer.findPosition(boxes[0]);
        if (position == null) {
            for (Box box : boxes[0].getAllRotations()) {
                position = boxContainer.findPosition(box);
                if (position != null) {
                    // use the new rotation
                    boxContainer.getPlacedBoxes().add(new PositionedBox(position, box));
                    System.out.println(boxContainer.getPlacedBoxes().toString());
                    System.out.println("end 1");
                }
            }
        } else {
            System.out.println(position);
        }

        position = boxContainer.findPosition(boxes[1]);
        if (position == null) {
            for (Box box : boxes[1].getAllRotations()) {
                position = boxContainer.findPosition(box);
                if (position != null) {
                    // use the new rotation
                    boxContainer.getPlacedBoxes().add(new PositionedBox(position, box));
                    System.out.println(boxContainer.getPlacedBoxes().toString());
                    System.out.println("end 2");
                }
            }
        } else {
            System.out.println(position);
        }
    }
    @Test
    public void testDeleteBox() {
        BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
        Box a = new Box(3, 3, 3);
        Box b = new Box(4, 4, 4);
        Box c = new Box(1, 1, 1);

        Point position = boxContainer.findPosition(a);
        boxContainer.getPlacedBoxes().add(new PositionedBox(position, a));
        position = boxContainer.findPosition(b);
        boxContainer.getPlacedBoxes().add(new PositionedBox(position, b));
        Assert.assertEquals(2, boxContainer.getPlacedBoxes().size());

        position = boxContainer.findPosition(c);
        boxContainer.getPlacedBoxes().add(new PositionedBox(position, c));
        boxContainer.getPlacedBoxes().remove(boxContainer.getPlacedBoxes().size() - 1);
        Assert.assertEquals(2, boxContainer.getPlacedBoxes().size());
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

        Assert.assertFalse(boxContainer.insideTheBox(positionedBox));


    }
}
