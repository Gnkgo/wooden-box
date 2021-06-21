package ch.brodbeck.solver;

import java.util.Iterator;

public class Solver {
    BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
    Box[] boxes = new Box[]{
            // Cubes
            new Box(3, 3, 3),
            new Box(4, 4, 4),
            // Flat planks
            new Box(4, 3, 1),
            new Box(5, 4, 1),
            new Box(6, 3, 1),
            new Box(7, 3, 1),
            new Box(10, 3, 1),
            // Thick planks
            new Box(4, 3, 2),
            new Box(6, 3, 2),
            new Box(7, 3, 2),
            new Box(7, 4, 2)
    };

    public void solve() {
        while (!boxContainer.fullBoxContainer()) {
            int newBoxes = 0;
            if (boxContainer.findPosition((boxes[newBoxes])) != null) {
                Point position = boxContainer.findPosition(boxes[newBoxes]);
                for (int existingBoxes = 0; existingBoxes < boxContainer.countBoxes(); existingBoxes++) {
                    if (new PositionedBox(position, boxes[newBoxes]).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))) {
                        //todo
                        //when the position is colliding with an already existing box, try the rotations, if this doesn't work, go to the last working box
                        // things to do:
                        // 1) iterators are wrong, how to iterate through all elements
                        // 2) look at the different loops
                        // 3) get solution, if it doesn't collide --> second step, find out where/which method to use for the recursion
                        for (Iterator<Box> it = boxes[newBoxes].getAllRotations().iterator(); it.hasNext(); ) {
                            Box rotatedBox = it.next();
                            if (!new PositionedBox(position, boxes[newBoxes]).collidesWith(boxContainer.getPlacedBoxes(existingBoxes)))
                                boxContainer.placeBox(boxes[newBoxes], boxContainer.findPosition(boxes[newBoxes]));
                            Iterator <Box> rotatedBox = boxes[newBoxes].getAllRotations().iterator();
                            rotatedBox.next();
                            //with iterator --> iterate through hashset
                            boxes[newBoxes] = (Box) rotatedBox;
                            //if it does collide, try next rotated box
                        }
                    } else {
                        boxContainer.placeBox(boxes[newBoxes], boxContainer.findPosition(boxes[newBoxes]));
                    }
                }
            }
            // when no place is found
            else {
                //todo
                //recursion back to the last possible box and try from there
            }
        }
    }
}
