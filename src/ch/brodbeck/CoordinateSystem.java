package ch.brodbeck;
import java.util.Arrays;

public class CoordinateSystem {
    public int[][][] coordinate = new int[10][7][5];

    /*
    height = z
    length = y
    width = x
     */

    public static Box TargetBox = new Box(10, 7, 5);
    public static Box[] Boxes = new Box[] {
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
            new Box(7, 4, 2),
    };

    public CoordinateSystem() {
        for (int[][] row : coordinate) {
            for (int[] column : row) {
                Arrays.fill(column, -1);
            }
        }
    }
    public void checkPossibility() {
    }

    public void boxLeft() {
        //int index = ArrayUtils.indexOf(numbers, element);
    }

    public boolean checkCollision(int givenX, int givenY, int givenZ, int givenBoxID, int x, int y, int z, int boxID) {
        int[] pointLeft = getLeftCorner(x, y, z);
        int[] givenPointLeft = getLeftCorner(givenX, givenY, givenZ);
        int[] pointRight = getRightCorner(x, y, z, boxID);
        int[] givenPointRight = getRightCorner(givenX, givenY, givenZ, givenBoxID);

        if ((givenX + x > 10) || (givenY + y > 7) || (givenZ + z > 5)) {
            return false;
        }

        if (givenBoxID == boxID) {
            return false;
        }

        for (int i = 0; i<3; i++ ) {
            if ((pointLeft[i] > givenPointLeft[i]) && (
                    pointLeft[i] < givenPointRight[i])) {
                return false;
            }
        }
        for (int j = 0; j<3; j++ ) {
            if ((pointRight[j] < givenPointRight[j]) &&
                    (pointRight[j] > givenPointLeft[j])){
                return false;
            }
        }
        return true;
        //get collision with corners of the box
    }

    public int[][][] placeBox(int x, int y, int z, int boxID) {
        for (int i = x; i < x + Boxes[boxID].length; ++i) {
            coordinate[i][y][z] = boxID;
        }
            for(int j = y; j < y + Boxes[boxID].width; ++j) {
                coordinate[x][j][z] = boxID;
            }
                for(int k = z; k < Boxes[boxID].height; ++k){
                    coordinate[x][y][k] = boxID;
                }
        //checkCollision(givenX, givenY, givenZ, givenBoxID, x, y, z, boxID);
        return coordinate;
    }
            /*
            exception when array is too short,
            then this combination doesn't work,
            either rotate Box or choose another combination
             */

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
/*
    public int[][][] deleteBox(int boxID) {
        for (int[][] array2D: coordinate) {
            for (int[] array1D: array2D) {
                for(int item: array1D) {
                    if (coordinate[array2D][array1D][item] == boxID) {
                        coordinate[array2D][array1D][item] = -1;
                    }
                }
            }
        }
        return coordinate;
    }
 */

    public int[] getLeftCorner(int x, int y, int z) {
        return new int[]{x, y, z};
    }

    public int[] getRightCorner(int x, int y, int z, int boxID) {
        return new int[] { x + Boxes[boxID].getWidth(),
        y + Boxes[boxID].getLength(),
        z + Boxes[boxID].getHeight()};
    }

    public void rotateLengthWidth(int length, int width) {
        int a = width;
        width = length;
        length = a;
    }

    public void rotateLengthHeight(int length, int height) {
        int a = height;
        height = length;
        length = a;
    }

    public void rotateHeightWidth(int height, int width) {
        int a = height;
        height = width;
        width = a;

    }
}

