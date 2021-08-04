package ch.brodbeck.solver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolverRecursive {

    public List<PositionedBox> solveBox(BoxContainer boxContainer, List<Box> leftBoxes) {
        if (leftBoxes.size() == 0) {
            // exit condition --> finish recursion
            return boxContainer.getAllPlacedBoxes();
        }
        for (int i = 0; i < leftBoxes.size(); i++) {
            var leftBox = leftBoxes.get(i);

            // when not a position is found for any boxes which are left
            if (boxContainer.findPosition(leftBox) == null && i == leftBoxes.size() - 1) {
                leftBoxes.add(boxContainer.getPlacedPlainBoxes(i));
                boxContainer.deleteBox();
                return null;
            }
            if (boxContainer.getPlacedBoxesSize() == 0) {
                BoxContainer boxContainer1 = new BoxContainer(boxContainer.getTargetBox());
                List <Box> leftBoxes1 = new ArrayList<Box>(leftBoxes);
                boxContainer1.placeBox(leftBox, boxContainer.findPosition(leftBox));
                leftBoxes1.remove(i);
                return solveBox(boxContainer1, leftBoxes1);
            }
            Point position = boxContainer.findPosition(leftBox);
            for (int j = 0; j < boxContainer.getPlacedBoxesSize(); j++) {

                // when the position is colliding with an already existing box, try the rotations
                if (new PositionedBox(position, leftBox).collidesWith(boxContainer.getPlacedBoxes(j))) {
                    for (Box box : leftBox.getAllRotations()) {
                        Iterator<Box> itr = leftBox.getAllRotations().iterator();
                        itr.next();
                        if (!new PositionedBox(position, box).collidesWith(boxContainer.getPlacedBoxes(j))) {
                            // use the new rotation
                            BoxContainer boxContainer1 = new BoxContainer(boxContainer.getTargetBox());
                            List <Box> leftBoxes1 = new ArrayList<Box>(leftBoxes);
                            boxContainer1.placeBox(leftBox, boxContainer.findPosition(leftBox));
                            leftBoxes1.remove(i);
                            return solveBox(boxContainer1, leftBoxes1);
                        }
                    }
                } else {
                    // if nothing happened --> place it
                    BoxContainer boxContainer1 = new BoxContainer(boxContainer.getTargetBox());
                    List <Box> leftBoxes1 = new ArrayList<Box>(leftBoxes);
                    boxContainer1.placeBox(leftBox, boxContainer.findPosition(leftBox));
                    leftBoxes1.remove(i);
                    return solveBox(boxContainer1, leftBoxes1);
                }
            }
        }
        return solveBox(boxContainer, leftBoxes);
    }
}

