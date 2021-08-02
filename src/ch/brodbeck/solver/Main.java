package ch.brodbeck.solver;
import ch.brodbeck.solver.Box;

import javax.swing.text.Position;
import java.util.Iterator;

public class Main {
    private static BoxContainer boxContainer = new BoxContainer(new Box(10, 7, 5));
    private static Box[] boxes = new Box[] {
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


    }
}
