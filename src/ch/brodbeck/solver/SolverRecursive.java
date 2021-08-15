package ch.brodbeck.solver;

import java.util.ArrayList;
import java.util.List;

public class SolverRecursive {

    public List<PositionedBox> solveBox(BoxContainer boxContainer, List<Box> leftBoxes) {
        BoxContainer boxContainer1 = new BoxContainer(boxContainer.getTargetBox());
        for (int i = 0; i < boxContainer.getPlacedBoxes().size() ; i++) {
            boxContainer1.getPlacedBoxes().add(i, boxContainer.getPlacedBoxes().get(i));
        } // can I copy that easier?
        List <Box> leftBoxes1 = new ArrayList<>(leftBoxes);

        if (leftBoxes1.size() == 0) {
            // exit condition --> finish recursion
            return boxContainer1.getPlacedBoxes();
        }

        for (int i = 0; i < leftBoxes1.size(); i++) {
            var leftBox = leftBoxes1.get(i);
            for (Box box : leftBox.getAllRotations()) {
                Point position = boxContainer1.findPosition(box);
                if (position != null) {
                    // use the new rotation
                    boxContainer1.getPlacedBoxes().add(new PositionedBox(position, box));
                    leftBoxes1.remove(i);
                    var result = solveBox(boxContainer1, leftBoxes1);
                    if (result != null) {
                        return result;
                    } else {
                        leftBoxes1.add(boxContainer1.getPlacedBoxes().get(boxContainer1.getPlacedBoxes().size() - 1).getPlainBox());
                        boxContainer1.getPlacedBoxes().remove(boxContainer1.getPlacedBoxes().size() -1);
                        break;
                    }
                }
                // when the position is colliding with an already existing box, try the rotations
                // if nothing happened, and you checked every box --> place it
            }
        }
        // when no position is found for any boxes which are left
        return null;
    }
}

