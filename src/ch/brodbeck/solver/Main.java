package ch.brodbeck.solver;
import ch.brodbeck.solver.Box;

import javax.swing.text.Position;
import java.util.Iterator;

public class Main {
    private static BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
    private static Box[] boxes = new Box[] {
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


    public static void main(String[] args) {
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
                    if (new PositionedBox(position, boxes[newBoxes]).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))){
                        for (Box box : boxes[newBoxes].getAllRotations()) {
                            Iterator <Box> itr = boxes[newBoxes].getAllRotations().iterator();
                            itr.next();
                            if (!new PositionedBox(position, box).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))) {
                                // use the new rotation
                                boxContainer.placeBox(boxes[newBoxes], boxContainer.findPosition(boxes[newBoxes]));
                                break outerLoop;
                            }
                            // if there aren't any other rotations anymore, remove box and skip this box
                            else if (!itr.hasNext()){
                                boxContainer.deleteBox();
                                counter--;
                                visitedPath[newBoxes] = 1;
                                break outerLoop;
                            }
                        }
                    }
                    else {
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
