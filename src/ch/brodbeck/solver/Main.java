package ch.brodbeck.solver;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
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


    public static void main(String[] args) throws InterruptedException {
        List<ArrayList<Box>> collect = new ArrayList<>();
        List<Box> toShuffleCopy = Arrays.asList(boxes);
        List<Box> toShuffle = new ArrayList<>(toShuffleCopy);
        Thread t = Thread.currentThread();

        for (int i = 0; i < 11; i++) {
            Collections.shuffle(toShuffle);
            toShuffle.remove(boxes[i]);
            toShuffle.add(0, boxes[i]);
            collect.add(new ArrayList<>(toShuffle));
            System.out.println(toShuffle);
        }
        Object lock = new Object();
        Thread[] threads = new Thread[11];
        for (int i = 0; i < 11; i++) {
            SolverRecursive solverRecursive1 = new SolverRecursive(boxContainer, collect.get(i), lock);
            threads[i] = new Thread(solverRecursive1);
            threads[i].start();
        }

        synchronized (lock) {
            try {
                lock.wait();
                for (Thread thread : threads) {
                    if (thread.isAlive()) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                throw new InterruptedException();
            }
        }
    }
}
