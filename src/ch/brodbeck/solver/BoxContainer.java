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

    public Box getPlacedPlainBoxes(int i) {
        return placedBoxes.get(i).getPlainBox();
    }

    public PositionedBox getPlacedBoxes(int i) {
        return placedBoxes.get(i);
    }

    public List<PositionedBox> getAllPlacedBoxes() {
        return placedBoxes;
    }

    public Point getPlainPosition (int i) {
        return placedBoxes.get(i).getPlainPoint();
    }
    public int countBoxes() {
        return this.placedBoxes.size();
    }

    public int getPlacedBoxesSize(){
        return placedBoxes.size();
    }

    public void placeBox(Box box, Point position) {
        this.placedBoxes.add(new PositionedBox(position, box));
    }

    public void deleteBox() {
        this.placedBoxes.remove(placedBoxes.size()-1);
    }

    public boolean outOfBox(PositionedBox attempt) {
        if (attempt.getPlainBox().getLength() + attempt.getPlainPoint().getX() > targetBox.getLength()) {
            return false;
        }
        else if (attempt.getPlainBox().getWidth() + attempt.getPlainPoint().getY() > targetBox.getWidth()) {
            return false;
        }
        else return attempt.getPlainBox().getHeight() + attempt.getPlainPoint().getZ() <= targetBox.getHeight();
    }


    public Point findPosition(Box box) {
        for (int z = 0; z < targetBox.getHeight(); z++) {
            for (int y = 0; y < targetBox.getLength(); y++) {
                for (int x = 0; x < targetBox.getWidth(); x++) {
                    Point position = new Point(x, y, z);
                    PositionedBox attempt = new PositionedBox(position, box);
                    if (placedBoxes.size() == 0 && outOfBox(attempt)) {
                        return position;
                    }
                    int counter = 0;
                    for (PositionedBox placedBox : placedBoxes) {
                        if (!attempt.collidesWith(placedBox) && outOfBox(attempt)) {
                            counter++;
                            if (counter == placedBoxes.size()) {
                                return position;
                            }
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
