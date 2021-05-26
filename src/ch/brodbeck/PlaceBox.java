package ch.brodbeck;
import static ch.brodbeck.CoordinateSystem.Boxes;
import static ch.brodbeck.CoordinateSystem.coordinate;

public class PlaceBox extends DeleteBox{
    public int[][][] placeBox(int x, int y, int z, int boxID) {
        for (int i = z; i < z + Boxes[boxID].getHeight(); ++i) {
            coordinate[i][y][z] = boxID;

            for (int j = y; j < y + Boxes[boxID].getLength(); ++j) {
                coordinate[i][j][z] = boxID;

                for (int k = x; k < x + Boxes[boxID].getWidth(); ++k) {
                    coordinate[i][j][k] = boxID;
                }
            }
        }
        System.out.println(coordinate[x][y][z]);
        System.out.println(coordinate[x+1][y+1][z+1]);
        return coordinate;
    }
}
