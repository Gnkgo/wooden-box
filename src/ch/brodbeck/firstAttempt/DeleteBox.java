package ch.brodbeck.firstAttempt;
import static ch.brodbeck.firstAttempt.CoordinateSystem.coordinate;

public class DeleteBox extends SpacesWithBoxID{
    public int[][][] deleteBox(int boxID) {
        for (int i = 0; i < coordinate.length; ++i) {
            for(int j = 0; j < coordinate[i].length; ++j) {
                for(int k = 0; k < coordinate[i][j].length; ++k) {
                    if (coordinate[i][j][k] == boxID) {
                        coordinate[i][j][k] = -1;
                    }
                }
            }
        }
        return coordinate;
        // use traceback algorithm --> fast way to achieve goal
    }
}
