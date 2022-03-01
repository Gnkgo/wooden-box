package ch.brodbeck.solver;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class Main {
    private static final BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
    private static final Box[] boxes = new Box[]{
            // Cubes
            new Box(3, 3, 3),

            new Box(7, 3, 1),
            new Box(10, 3, 1),
            new Box(6, 3, 1),
            new Box(5, 4, 1),
            new Box(7, 3, 2),
            new Box(7, 4, 2),
            new Box(4, 3, 1),
            new Box(4, 4, 4),
            // Flat planks





            // Thick planks
            new Box(4, 3, 2),
            new Box(6, 3, 2)


    };

    public static void main(String[] args) {
        List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
        //List<PositionedBox> solution = solverRecursive.solveBox(boxContainer, leftBoxes);

        for (int i = 0; i < 10; i++) {
            SolverRecursive solverRecursive1 = new SolverRecursive(boxContainer, leftBoxes);
            Collections.shuffle(leftBoxes);
            Thread thread = new Thread(solverRecursive1);
            thread.start();
        }
    }
}
