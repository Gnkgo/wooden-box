package ch.brodbeck.fastSolver;

import ch.brodbeck.solver.Box;
import ch.brodbeck.solver.BoxContainer;
import ch.brodbeck.solver.Point;
import ch.brodbeck.solver.PositionedBox;
import org.junit.Assert;
import org.junit.Test;

public class SolverTest {
    public int[][] createBoxes() {

        int[][] boxes = new int[11][];
        // Cubes
        boxes[0] = new int[]{3, 3, 3};
        boxes[1] = new int[]{4, 4, 4};
        // Flat planks
        boxes[2] = new int[]{4, 3, 1};
        boxes[3] = new int[]{6, 3, 1};
        boxes[4] = new int[]{5, 4, 1};
        boxes[5] = new int[]{7, 3, 1};
        boxes[6] = new int[]{10, 3, 1};
        // Thick planks
        boxes[7] = new int[]{4, 3, 2};
        boxes[8] = new int[]{6, 3, 2};
        boxes[9] = new int[]{7, 3, 2};
        boxes[10] = new int[]{7, 4, 2};

        return boxes;
    }

    public int[][] createSortedBoxes() {
        int[][] boxes = new int[11][];
        // Cubes
        boxes[0] = new int[]{3, 3, 3};
        boxes[8] = new int[]{4, 4, 4};
        // Flat planks
        boxes[7] = new int[]{3, 1, 4};
        boxes[3] = new int[]{6, 1, 3};
        boxes[4] = new int[]{4, 1, 5};
        boxes[1] = new int[]{7, 3, 1};
        boxes[2] = new int[]{10, 3, 1};
        // Thick planks
        boxes[9] = new int[]{3, 4, 2};
        boxes[10] = new int[]{6, 3, 2};
        boxes[5] = new int[]{3, 7, 2};
        boxes[6] = new int[]{7, 2, 4};

        return boxes;
    }

    @Test
    public void checkSolver() {
        int[][] boxes = createSortedBoxes();
        boolean[][][] boxContainer = new boolean[10][7][5];
        boolean[] used = new boolean[11];
        Solver solver = new Solver(boxes, boxContainer, used);
        solver.solve();
    }


    public int[][] createSmallBox() {
        int[][] boxes = new int[3][];
        boxes[0] = new int[]{1, 3, 5};
        boxes[1] = new int[]{2, 3, 4};
        boxes[2] = new int[]{1, 2, 3};
        return boxes;

    }

    @Test
    public void checkSmall() {
        int[][] boxesSmall = createSmallBox();
        boolean[][][] boxContainerSmall = new boolean[3][5][3];
        boolean[] used = new boolean[3];
        Solver solver = new Solver(boxesSmall, boxContainerSmall, used);
        solver.solve();
    }

    public int[][] collisionBox() {
        int[][] boxes = new int[3][];
        boxes[0] = new int[]{3, 3, 3};
        boxes[1] = new int[]{4, 4, 4};
        boxes[2] = new int[]{1, 1, 1};
        return boxes;
    }

    @Test
    public void testDeleteBox() {
        int[][] boxesSmall = collisionBox();
        boolean[][][] boxContainerSmall = new boolean[10][8][8];
        boolean[] used = new boolean[3];

        Solver solver = new Solver(boxesSmall, boxContainerSmall, used);
        int[] pos = solver.findPos();
        solver.placeBox(pos[0], pos[1], pos[2], collisionBox()[0]);
        solver.used[0] = true;
        pos = solver.findPos();
        solver.placeBox(pos[0], pos[1], pos[2], collisionBox()[1]);
        solver.used[1] = true;
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            if (solver.used[i]) {
                counter++;
            }
        }
        Assert.assertEquals(2, counter);

        pos = solver.findPos();
        solver.placeBox(pos[0], pos[1], pos[2], collisionBox()[2]);
        solver.used[2] = true;
        solver.removeBox(pos[0], pos[1], pos[2], collisionBox()[2]);
        solver.used[1] = false;
        counter = 0;
        for (int i = 0; i < 3; i++) {
            if (solver.used[i]) {
                counter++;
            }
        }
        Assert.assertEquals(2, counter);
    }
}
