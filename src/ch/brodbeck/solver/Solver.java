package ch.brodbeck.solver;

import java.util.Arrays;
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

/*
    public void solve() {
        int[] placedBoxes = new int[boxes.length];
        Arrays.fill(placedBoxes, 1);
        int counter = 0;
        int newBoxes = 0;
        int collideCounter = 0;
        // do as long as the box is not full yet
        while (!boxContainer.fullBoxContainer()) {
            //when there is a position for a new box then:
            if (boxContainer.findPosition((boxes[newBoxes])) != null) {
                Point position = boxContainer.findPosition(boxes[newBoxes]);
                // if new box does collide with something:
                for (int existingBoxes = 0; existingBoxes < boxContainer.countBoxes(); existingBoxes++) {
                    if (new PositionedBox(position, boxes[newBoxes]).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))) {
                        // try the rotations
                        for (Box rotatedBox : boxes[newBoxes].getAllRotations()) {
                            for (int i = 0; i < boxContainer.countBoxes(); i++) {
                                // if rotation collides, try next rotation
                                if (new PositionedBox(position, rotatedBox).collidesWith(boxContainer.getPlacedBoxes(i))) {
                                    collideCounter++;
                                    break;
                                }
                            }
                        }
                        //when nothing collided, place the box
                        if (collideCounter == 0) {
                            boxContainer.placeBox(boxes[newBoxes], boxContainer.findPosition(boxes[newBoxes]));
                            placedBoxes[newBoxes] = 0;
                            newBoxes++;
                            // if something collided, go to the next box but don't place it
                        } else {
                            newBoxes++;
                            collideCounter = 0;
                        }
                    }
                    //todo: problem with remembering the right boxes --> placing two identical boxes are not possible!
                }
                boxContainer.placeBox(boxes[newBoxes], boxContainer.findPosition(boxes[newBoxes]));
                placedBoxes[newBoxes] = 0;
                newBoxes++;
            }
            // when no place is found
            else {
                //should not only do this, if newBoxes is boxes.length, should backtrack until last working box...
                if (newBoxes == boxes.length) {
                    boxContainer.deleteBox();
                    placedBoxes[counter] = 0;
                    counter--;
                }
                //todo: newBoxes will reach infinity, how to go backwards and really "Backtrack"?
                newBoxes++;
                //recursion back to the last possible box and try from there
            }
        }
    }

    public class solveTwo {
        private static BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
        private static Box[] boxes = new Box[]{
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

        public void solveTwo() {
            int[] visitedPath = new int[boxes.length];
            int[] usedPath = new int[boxes.length];
            int counter = 0;
            while (!boxContainer.fullBoxContainer()) {
                outerLoop:
                for (int newBoxes = 0; newBoxes < boxes.length; newBoxes++) {
                    // when not even a position is found
                    if (boxContainer.findPosition((boxes[newBoxes])) == null) {
                        boxContainer.deleteBox();
                        counter--;
                        continue;
                    } // what if more than one box has to be removed?
                    Point position = boxContainer.findPosition(boxes[newBoxes]);
                    for (int existingBoxes = 0; existingBoxes < boxContainer.countBoxes(); existingBoxes++) {
                        // when the position is colliding with an already existing box, try the rotations
                        if (new PositionedBox(position, boxes[newBoxes]).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))) {
                            for (Box box : boxes[newBoxes].getAllRotations()) {
                                Iterator<Box> itr = boxes[newBoxes].getAllRotations().iterator();
                                itr.next();
                                if (!new PositionedBox(position, box).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))) {
                                    // use the new rotation
                                    boxContainer.placeBox(boxes[newBoxes], boxContainer.findPosition(boxes[newBoxes]));
                                    break outerLoop;
                                }
                                // if there aren't any other rotations anymore, remove box and skip this box
                                else if (!itr.hasNext()) {
                                    boxContainer.deleteBox();
                                    counter--;
                                    visitedPath[newBoxes] = 1;
                                    break outerLoop;
                                }
                            }
                        } else {
                            // if nothing happened --> place it
                            boxContainer.placeBox(boxes[newBoxes], boxContainer.findPosition(boxes[newBoxes]));
                            counter++;
                            usedPath[newBoxes] = 1;
                        }
                    }
                }
            }
        }
    }
 */

}


