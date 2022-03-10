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

    public Box getTargetBox() {
        return targetBox;
    }

    public List<PositionedBox> getPlacedBoxes(){
        return placedBoxes;
    }

    public boolean insideTheBox(PositionedBox attempt) {
        if (attempt.getPlainBox().getLength() + attempt.getPlainPoint().getX() > targetBox.getLength()) {
            return false;
        }
        else if (attempt.getPlainBox().getWidth() + attempt.getPlainPoint().getY() > targetBox.getWidth()) {
            return false;
        }
        else return attempt.getPlainBox().getHeight() + attempt.getPlainPoint().getZ() <= targetBox.getHeight();
    }


    public Point findPosition(Box box) {
        for (int z = 0; z <= targetBox.getHeight() - box.getHeight(); z++) {
            for (int y = 0; y <= targetBox.getWidth() - box.getWidth(); y++) {
                for (int x = 0; x <= targetBox.getLength() - box.getLength(); x++) {
                    Point position = new Point(x, y, z);
                    PositionedBox attempt = new PositionedBox(position, box);
                    if (placedBoxes.size() == 0) {
                        return position;
                    }
                    int counter = 0;
                    for (PositionedBox placedBox : placedBoxes) {
                        if (!attempt.collidesWith(placedBox)) {
                            counter++;
                            if (counter == placedBoxes.size()) {
                                return position;
                            }
                        } else {
                            x = Math.max(x, placedBox.getPlainPoint().getX() + placedBox.getPlainBox().getLength());
                            break;
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
