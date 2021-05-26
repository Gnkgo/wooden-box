package ch.brodbeck.solver;

import java.util.ArrayList;
import java.util.List;

public class BoxContainer {
    private final Box targetBox;
    private List<PositionedBox> placedBoxes;

    public BoxContainer(Box targetBox){
        this.targetBox = targetBox;
        this.placedBoxes = new ArrayList<PositionedBox>();
    }

    public void placeBox(Box box, Point position) {
        this.placedBoxes.add(new PositionedBox(position, box));
    }

    public Point findPosition(Box box) {
        for (int z = 0; z < targetBox.getHeight(); z++) {
            for (int y = 0; y < targetBox.getLength(); y++) {
                for (int x = 0; x < targetBox.getWidth(); x++) {
                    Point position = new Point(x, y, z);
                    PositionedBox attempt = new PositionedBox(position, box);
                    if (placedBoxes.size() == 0) {
                        return position;
                    }
                    for (PositionedBox placedBox : placedBoxes) {
                        if (!attempt.collidesWith(placedBox)) {
                            return position;
                        }
                    }
                }
            }
        }
        return null;
        //search targetBox to find a suitable place for given box
        //when no place is found --> return null
    }

}
