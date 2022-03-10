package ch.brodbeck.solver;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolverTest {
    @Test
    public void checkSolver() {
        BoxContainer boxContainer = new BoxContainer(new Box(5, 5, 5));
        Box[] boxes = new Box[] {
                new Box(1, 1, 1),
                new Box(2, 2, 2),
                new Box(3, 3, 3),
        };

        List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
        //SolverRecursive solverRecursive = new SolverRecursive(boxContainer, leftBoxes);
        //List<PositionedBox> solution = solverRecursive.solveBox(boxContainer, leftBoxes);

        for (int i = 0; i < boxes.length; i++) {
            //System.out.println(solution.get(i).toString());
        }
    }
    @Test
    public void checkSolverRotation() {
        BoxContainer boxContainer = new BoxContainer(new Box(3, 5, 3));
        Box[] boxes = new Box[]{
                new Box(1, 3, 5),
                new Box(2, 3, 4),
                new Box(1, 2, 3),
        };

        List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
        //SolverRecursive solverRecursive = new SolverRecursive(boxContainer, leftBoxes);
        long start = System.currentTimeMillis();
        //List<PositionedBox> solution = solverRecursive.solveBox(boxContainer, leftBoxes);
        long totalTime = System.currentTimeMillis() - start;
        for (int i = 0; i < boxes.length; i++) {
            //System.out.println(solution.get(i).toString());
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(totalTime);
        System.out.println(start);
    }

    @Test
    public void bigTest() {
        BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
        Box[] boxes = new Box[]{
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


            List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
            SolverRecursiveSingle solverRecursiveSingle = new SolverRecursiveSingle();
            long start = System.currentTimeMillis();
            List<PositionedBox> solution = solverRecursiveSingle.solveBox(boxContainer, leftBoxes);
            long totalTime = System.currentTimeMillis() - start;
            for (int i = 0; i < boxes.length; i++) {
                System.out.println(solution.get(i).toString());
            }
            long totalTimeMinutes = totalTime / 1000 / 60;
            System.out.println("The solver had " + totalTimeMinutes + " minutes or " + totalTimeMinutes / 60 + " hours to solve the box.");
    }

    @Test
    public void bigTestSorted() {
        BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
        Box[] boxes = new Box[]{
                new Box(3, 3, 3),
                new Box(7, 3, 1),
                new Box(10, 3, 1),
                new Box(6, 3, 1),
                new Box(5, 4, 1),
                new Box(7, 3, 2),
                new Box(7, 4, 2),
                new Box(4, 3, 1),
                new Box(4, 4, 4),
                new Box(4, 3, 2),
                new Box(6, 3, 2)
        };


        List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
        SolverRecursiveSingle solverRecursiveSingle = new SolverRecursiveSingle();
        long start = System.currentTimeMillis();
        List<PositionedBox> solution = solverRecursiveSingle.solveBox(boxContainer, leftBoxes);
        long totalTime = System.currentTimeMillis() - start;
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(solution.get(i).toString());
        }
        long totalTimeMinutes = totalTime / 1000 / 60;
        System.out.println("The solver had " + totalTimeMinutes + " minutes or " + totalTimeMinutes / 60 + " hours to solve the box.");
    }
}
