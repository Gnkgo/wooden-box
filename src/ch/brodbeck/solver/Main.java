package ch.brodbeck.solver;
import ch.brodbeck.solver.Box;

import javax.swing.text.Position;

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
        while (!boxContainer.fullBoxContainer()) {
            for (int i = 0; i < 11; i++) {
                if (boxContainer.findPosition((boxes[i])) == null) {
                    boxContainer.deleteBox();
                    i -= 1;
                    continue;
                } //what if more than one box has to be deleted?
                Point position = boxContainer.findPosition(boxes[i]);
                for (int j = 0; j < boxContainer.countBoxes(); j++) {
                    if (new PositionedBox(position, boxes[i]).collidesWith(boxContainer.getPlacedBoxes(i))){
                        boxes[i].getAllRotations();
                        // use the new rotation
                    }
                }
                boxContainer.placeBox(boxes[i], boxContainer.findPosition(boxes[i]));
                // if nothing happened --> place it
            }
        }
    }
}
