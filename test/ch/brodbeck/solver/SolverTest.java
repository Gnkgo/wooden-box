package ch.brodbeck.solver;

import org.junit.Test;

import java.util.ArrayList;
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
        SolverRecursive solverRecursive = new SolverRecursive(boxContainer);
        ArrayList<Box> placedBoxes = new ArrayList<Box>();
        ArrayList<Box> leftBoxes = new ArrayList<Box>(List.of(boxes));
        ArrayList<Box> solution = solverRecursive.solveBox(placedBoxes, leftBoxes);
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(solution.get(i));
        }
        System.out.println(solution.toString());
    }
}
