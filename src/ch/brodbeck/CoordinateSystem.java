package ch.brodbeck;
import java.util.Arrays;

public class CoordinateSystem {
    public int[][][] coordinate = new int[50][35][25];

    /*
    height = z
    length = y
    width = x
     */
    public static Box TargetBox = new Box(50, 35, 25);
    public static Box[] Boxes = new Box[] {
            // Cubes
            new Box(15, 15, 15),
            new Box(20, 20, 20),
            // Flat planks
            new Box(20, 15, 5),
            new Box(25, 20, 5),
            new Box(30, 15, 5),
            new Box(35, 15, 5),
            new Box(50, 15, 5),
            // Thick planks
            new Box(20, 15, 10),
            new Box(30, 15, 10),
            new Box(35, 15, 10),
            new Box(35, 20, 10),
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

        if (givenBoxID == boxID) {
            return false;
        }

        for (int i = 0; i<3; i++ ) {
            if ((pointLeft[i] > givenPointLeft[i]) &&
                    pointLeft[i] < givenPointRight[i]) {
                return false;
            }
        }
        for (int j = 0; j<3; j++ ) {
            if (pointRight[j] < givenPointRight[j]) {
                return false;
            }
        }
        return true;
        //get collision with corners of the box
    }


    public int[][][] placeBox(int givenX, int givenY, int givenZ, int givenBoxID, int x, int y, int z, int boxID) {
        checkCollision(givenX, givenY, givenZ, givenBoxID, x, y, z, boxID);
        for (int[][] row : coordinate) {
            for (int[] column : row) {
                Arrays.fill(column, boxID); //fill the numbers in so you can see which box is used
            }
        }
        return coordinate;
    }
            /*
            exception when array is too short,
            then this combination doesn't work,
            either rotate Box or choose another combination
             */

    public int[] getLeftCorner(int x, int y, int z) {
        return new int[]{x, y, z};
    }

    public int[] getRightCorner(int x, int y, int z, int boxID) {
        int[] rightTopCorner =
                        { x + Boxes[boxID].getWidth(),
                        y + Boxes[boxID].getLength(),
                        z + Boxes[boxID].getHeight()};

        return rightTopCorner;
    }

    //one method? getLeftCorner and getRightCorner? Mapping? Pair?

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

