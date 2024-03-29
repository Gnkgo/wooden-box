package ch.brodbeck.firstAttempt;
import static ch.brodbeck.firstAttempt.CoordinateSystem.Boxes;
import static ch.brodbeck.firstAttempt.CoordinateSystem.coordinate;

public class SpacesWithBoxID {
    public boolean checkSpacesWithBoxID(int boxID) {
        return (emptySpacesCount()[0] > Boxes[boxID].getWidth()) &&
                (emptySpacesCount()[1] > Boxes[boxID].getLength()) &&
                (emptySpacesCount()[2] > Boxes[boxID].getHeight());
    }

    public int[] emptySpacesCount() {
        int[] spaces = new int[3];
        int xCounter = 0;
        int yCounter = 0;
        int zCounter = 0;
        for (int[][] ints : coordinate) {
            if (ints[0][0] == -1) {
                zCounter++;
            }

            for (int j = 0; j < coordinate[j].length; ++j) {
                if (ints[j][0] == -1) {
                    yCounter++;
                }

                for (int k = 0; k < ints[j].length; ++k) {
                    if (ints[j][k] == -1) {
                        xCounter++;
                    }
                }
            }
        }
        spaces[0] = xCounter;
        spaces[1] = yCounter;
        spaces[2] = zCounter;
        return spaces;
    }
}
