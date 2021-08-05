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
        SolverRecursive solverRecursive = new SolverRecursive();
        List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
        List<PositionedBox> solution = solverRecursive.solveBox(boxContainer, leftBoxes);

        for (int i = 0; i < boxes.length; i++) {
            System.out.println(solution.get(i).toString());
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
        SolverRecursive solverRecursive = new SolverRecursive();
        List<Box> leftBoxes = new ArrayList<Box>(Arrays.asList(boxes));
        List<PositionedBox> solution = solverRecursive.solveBox(boxContainer, leftBoxes);

        for (int i = 0; i < boxes.length; i++) {
            System.out.println(solution.get(i).toString());
        }
    }
}
