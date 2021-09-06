package ch.brodbeck.solver;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Main {
    private static final BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
    private static final Box[] boxes = new Box[]{
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
            new Box(7, 4, 2)
    };

    public static void main(String[] args) {
        SolverRecursive solverRecursive = new SolverRecursive();
        List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
        long start = System.currentTimeMillis();
        List<PositionedBox> solution = solverRecursive.solveBox(boxContainer, leftBoxes);
        long totalTime = System.currentTimeMillis() - start;
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(solution.get(i).toString());
        }
        long totalTimeMinutes = totalTime / 1000 / 60;
        System.out.println("The solver had " + totalTimeMinutes + " minutes or " + totalTimeMinutes / 60 + " hours to solve the box.");
    }
}
