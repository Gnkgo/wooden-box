package ch.brodbeck.solver;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolverRecursive {

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
    public static ArrayList<Box> placedBoxes = new ArrayList<Box>();
    public static ArrayList<Box> leftBoxes = new ArrayList<Box>(List.of(boxes));

    public ArrayList<Box> solveBox(ArrayList<Box> placedBoxes, ArrayList<Box> leftBoxes) {

        if (placedBoxes.size() == 0) {
            // exit condition --> finish recursion
            return placedBoxes;
        }
        for (int newBoxes = 0; newBoxes < leftBoxes.size(); newBoxes++) {
            // when not a position is found for any boxes which are left
            if (boxContainer.findPosition(leftBoxes.get(newBoxes)) == null && newBoxes == leftBoxes.size() - 1) {
                leftBoxes.add(placedBoxes.get(newBoxes));
                placedBoxes.remove(placedBoxes.size() - 1);
                boxContainer.deleteBox();
                solveBox(placedBoxes, leftBoxes);
                //or return null?
            }
            Point position = boxContainer.findPosition(leftBoxes.get(newBoxes));
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
                solveBox(placedBoxes, leftBoxes);
            }
        }
        return placedBoxes;
    }
}
