package ch.brodbeck;
import java.util.Scanner;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class coordinateSystem {
    public int[][][] coordinate = new int[51][36][26];

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

    public void checkPossibility() {
    }

    public void boxLeft() {
        int index = ArrayUtils.indexOf(numbers, element);

    }

    public boolean checkCollision(int givenX, int givenY, int givenZ, int givenJ, int x, int y, int z, int j) {
        for (int i = 0; i<3; i++ ) {
            if ((getLeftCorner(x, y, z)[i] > getLeftCorner(givenX, givenY, givenZ)[i]) &&
                    (getLeftCorner(x, y, z)[i]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[i])) {
                return false;
            }
        }
        for (int k = 0; k<3; k++ ) {
            if ((getRightCorner(x, y, z, j)[k] > getLeftCorner(givenX, givenY, givenZ)[k]) &&
                    (getRightCorner(x, y, z, j)[k]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[k])) {
                return false;
            }
        }
        return true;
        //get collision with corners of the box
    }


    public int[][][] placeBox(int x, int y, int z, int j) {
        //checkCollision(x, y, z, j);
        for (int[][] row : coordinate) {
            for (int[] column : row) {
                Arrays.fill(column, j); //fill the numbers in so you can see which box is used
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

    public int[] getRightCorner(int x, int y, int z, int j) {
        int[] rightTopCorner = {
                coordinate
                        [x + Boxes[j].getWidth()]
                        [y + Boxes[j].getLength()]
                        [z + Boxes[j].getHeight()]
        };
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

