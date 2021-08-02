package ch.brodbeck.solver;

import java.util.ArrayList;
import java.util.Iterator;

public class SolverRecursive {
    private BoxContainer boxContainer;

    public SolverRecursive(BoxContainer boxContainer) {
        this.boxContainer = boxContainer;
    }

    public ArrayList<Box> solveBox(ArrayList<Box> placedBoxes, ArrayList<Box> leftBoxes) {

        if (leftBoxes.size() == 0) {
            // exit condition --> finish recursion
            return placedBoxes;
        }
        for (int newBoxes = 0; newBoxes < leftBoxes.size(); newBoxes++) {
            // when not a position is found for any boxes which are left
            if (boxContainer.findPosition(leftBoxes.get(newBoxes)) == null && newBoxes == leftBoxes.size() - 1) {
                leftBoxes.add(placedBoxes.get(newBoxes));
                placedBoxes.remove(placedBoxes.size() - 1);
                boxContainer.deleteBox();
                return solveBox(placedBoxes, leftBoxes);
                //or return null?
            }
            Point position = boxContainer.findPosition(leftBoxes.get(newBoxes));
            if (placedBoxes.size() == 0) {
                boxContainer.placeBox(leftBoxes.get(newBoxes), boxContainer.findPosition(leftBoxes.get(newBoxes)));
                placedBoxes.add(leftBoxes.get(newBoxes));
                leftBoxes.remove(newBoxes);
                return solveBox(placedBoxes, leftBoxes);

            }
            for (int existingBoxes = 0; existingBoxes < placedBoxes.size(); existingBoxes++) {
                // when the position is colliding with an already existing box, try the rotations
                if (new PositionedBox(position, leftBoxes.get(newBoxes)).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))) {
                    for (Box box : leftBoxes.get(newBoxes).getAllRotations()) {
                        Iterator<Box> itr = leftBoxes.get(newBoxes).getAllRotations().iterator();
                        itr.next();
                        if (!new PositionedBox(position, box).collidesWith(boxContainer.getPlacedBoxes(existingBoxes))) {
                            // use the new rotation
                            boxContainer.placeBox(leftBoxes.get(newBoxes), boxContainer.findPosition(leftBoxes.get(newBoxes)));
                            placedBoxes.add(leftBoxes.get(newBoxes));
                            leftBoxes.remove(newBoxes);
                        }
                    }
                    boxContainer.deleteBox();
                    leftBoxes.add(placedBoxes.get(newBoxes));
                    placedBoxes.remove(newBoxes);
                } else {
                    // if nothing happened --> place it
                    boxContainer.placeBox(leftBoxes.get(newBoxes), boxContainer.findPosition(leftBoxes.get(newBoxes)));
                    placedBoxes.add(leftBoxes.get(newBoxes));
                    leftBoxes.remove(newBoxes);
                }
                return solveBox(placedBoxes, leftBoxes);
            }
        }
        return solveBox(placedBoxes, leftBoxes);
    }
}
