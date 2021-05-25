package ch.brodbeck;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoordinateSystem extends Collision {
    public static int[][][] coordinate = new int[10][7][5];
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
}

