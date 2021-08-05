package ch.brodbeck.solver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolverRecursive {

    public List<PositionedBox> solveBox(BoxContainer boxContainer, List<Box> leftBoxes) {
        BoxContainer boxContainer1 = new BoxContainer(boxContainer.getTargetBox());
        for (int i = 0; i < boxContainer.getPlacedBoxesSize() ; i++) {
            boxContainer1.placeBox(boxContainer.getPlacedPlainBoxes(i), boxContainer.getPlainPosition(i));
        } // can I copy that easier?
        List <Box> leftBoxes1 = new ArrayList<Box>(leftBoxes);
        if (leftBoxes1.size() == 0) {
            // exit condition --> finish recursion
            return boxContainer1.getAllPlacedBoxes();
        }
        for (int i = 0; i < leftBoxes1.size(); i++) {
            var leftBox = leftBoxes1.get(i);

            // when not a position is found for any boxes which are left
            if (boxContainer1.findPosition(leftBox) == null && i == leftBoxes1.size() - 1) {
                leftBoxes1.add(boxContainer1.getPlacedPlainBoxes(i));
                boxContainer1.deleteBox();
                return null;
            }
            if (boxContainer1.getPlacedBoxesSize() == 0) {
                boxContainer1.placeBox(leftBox, boxContainer1.findPosition(leftBox));
                leftBoxes1.remove(i);
                return solveBox(boxContainer1, leftBoxes1);
            }
            Point position = boxContainer1.findPosition(leftBox);
            for (int j = 0; j < boxContainer1.getPlacedBoxesSize(); j++) {

                // when the position is colliding with an already existing box, try the rotations
                if (new PositionedBox(position, leftBox).collidesWith(boxContainer1.getPlacedBoxes(j))) {
                    for (Box box : leftBox.getAllRotations()) {
                        Iterator<Box> itr = leftBox.getAllRotations().iterator();
                        itr.next();
                        if (!new PositionedBox(position, box).collidesWith(boxContainer1.getPlacedBoxes(j))) {
                            // use the new rotation
                            boxContainer1.placeBox(leftBox, boxContainer1.findPosition(leftBox));
                            leftBoxes1.remove(i);
                            return solveBox(boxContainer1, leftBoxes1);
                        }
                    }
                } else {
                    // if nothing happened --> place it
                    boxContainer1.placeBox(leftBox, boxContainer1.findPosition(leftBox));
                    leftBoxes1.remove(i);
                    return solveBox(boxContainer1, leftBoxes1);
                }
            }
        }
        return null;
    }
}

