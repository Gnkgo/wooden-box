package ch.brodbeck;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public void traceBackAlgorithm() {
    }

    public boolean checkSpacesWithBoxID(int boxID) {
        return (emptySpacesCount()[0] > Boxes[boxID].width) &&
                (emptySpacesCount()[1] > Boxes[boxID].length) &&
                (emptySpacesCount()[2] > Boxes[boxID].height);
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

    public void boxLeft() {
        //int index = ArrayUtils.indexOf(numbers, element);
    }

    public boolean checkCollision(int givenX, int givenY, int givenZ, int givenBoxID, int x, int y, int z, int boxID) {
        int[] pointLeft = getLeftCorner(x, y, z);
        int[] givenPointLeft = getLeftCorner(givenX, givenY, givenZ);
        int[] pointRight = getRightCorner(x, y, z, boxID);
        int[] givenPointRight = getRightCorner(givenX, givenY, givenZ, givenBoxID);

        if (givenBoxID == boxID) {
            return true;
        }
        // try to use the whole coordination as "one" --> then use <> signs

        if ((pointLeft[0] > givenPointLeft[0]) &&
        (pointLeft[1] > givenPointLeft[1]) &&
                (pointLeft[2] > givenPointLeft[2])) {
            if ((pointLeft[0] > givenPointRight[0]) &&
                    (pointLeft[1] > givenPointRight[1]) &&
                    (pointLeft[2] > givenPointRight[2])) {
                return false;
            }
        }

        

        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                return ((pointLeft[i - 2] > givenPointLeft[i - 2]) && (
                        pointLeft[i - 2] < givenPointRight[i - 2])) &&
                        ((pointLeft[i] > givenPointLeft[i]) &&
                                (pointLeft[i] < givenPointRight[i]));
            }

            if (((pointLeft[i] > givenPointLeft[i]) && (
                    pointLeft[i] < givenPointRight[i])) &&
                    ((pointLeft[i + 1] > givenPointLeft[i + 1]) &&
                            (pointLeft[i + 1] < givenPointRight[i + 1]))) {
                return true;
            }
        }
        return false;
    }

    public int[][][] placeBox(int x, int y, int z, int boxID) {
        for (int i = z; i < z + Boxes[boxID].height; ++i) {
            coordinate[i][y][z] = boxID;

            for (int j = y; j < y + Boxes[boxID].length; ++j) {
                coordinate[i][j][z] = boxID;

                for (int k = x; k < x + Boxes[boxID].width; ++k) {
                     coordinate[i][j][k] = boxID;
            }
        }
    }
        //checkCollision(givenX, givenY, givenZ, givenBoxID, x, y, z, boxID);
        System.out.println(coordinate[x][y][z]);
        System.out.println(coordinate[x+1][y+1][z+1]);
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

    // set --> add
    public Set rotateLengthWidth(int length, int width, int height) {
        Set <Box> hash_Set = new HashSet <Box>  ();
        for (int i = 0; i < 6 ; i++) {
            int a = height;
            height = length;
            length = a;
            Box rotatedBox = new Box(length, width, height);
            hash_Set.add(rotatedBox);
        }
        return hash_Set;
    }
}

