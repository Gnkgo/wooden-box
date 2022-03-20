package ch.brodbeck.fastSolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solver {
    public boolean[][][] boxContainer;
    public int[][] boxes;
    public boolean[] used;

    public Solver(int[][] boxes, boolean[][][] boxContainer, boolean used[] ) {
        this.boxContainer = boxContainer;
        this.boxes = boxes;
        this.used = used;
    }

    public boolean placeable(int x, int y, int z, int[] box) {
        for (int i = x; i < x + box[0]; i++) {
            for (int j = y; j < y + box[1]; j++) {
                for (int k = z; k < z + box[2]; k++) {
                    if (i >= boxContainer.length || j >= boxContainer[0].length ||
                            k >= boxContainer[0][0].length || boxContainer[i][j][k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Set<int[]> getAllRotations(int box) {
        Set<int[]> hashSet = new HashSet<>();
        hashSet.add(new int[]{boxes[box][0], boxes[box][1], boxes[box][2]});
        hashSet.add(new int[]{boxes[box][0], boxes[box][2], boxes[box][1]});
        hashSet.add(new int[]{boxes[box][1], boxes[box][2], boxes[box][0]});
        hashSet.add(new int[]{boxes[box][1], boxes[box][0], boxes[box][2]});
        hashSet.add(new int[]{boxes[box][2], boxes[box][1], boxes[box][0]});
        hashSet.add(new int[]{boxes[box][2], boxes[box][0], boxes[box][1]});
        return hashSet;
    }

    public void solve() {
        System.out.println("Recursion start");
        solve(0);
        System.out.println("Finished");
    }

    private boolean solve(int depth) {
        if (depth == boxes.length) {
            System.out.println("There is a solution");
            return true;
        }
        int[] pos = findPos();

        for (int i = 0; i < boxes.length; i++) {
            if (used[i]) {
                continue;
            }
            Set<int[]> comb = getAllRotations(i);

            if (pos == null) {
                continue;
            }
            int x = pos[0];
            int y = pos[1];
            int z = pos[2];
            for (int[] box : comb) {
                if (placeable(x, y, z, box)) {
                    used[i] = true;
                    placeBox(x, y, z, box);
                    if (solve(depth + 1)) {
                        System.out.println("Box{" + "length=" + box[0] + ", width=" + box[1] + ", height=" + box[2] + "}"
                                + " Coordinates: x: " + x + " y: " + y + " z: " + z);
                        return true;
                    }
                    removeBox(x, y, z, box);
                    used[i] = false;
                }
            }
        }
        return false;
    }

    public void removeBox(int x, int y, int z, int[] box) {
        for (int i = x; i < x + box[0]; i++) {
            for (int j = y; j < y + box[1]; j++) {
                for (int k = z; k < z + box[2]; k++) {
                    boxContainer[i][j][k] = false;
                }
            }
        }
    }

    public void placeBox(int x, int y, int z, int[] box) {
        for (int i = x; i < x + box[0]; i++) {
            for (int j = y; j < y + box[1]; j++) {
                for (int k = z; k < z + box[2]; k++) {
                    boxContainer[i][j][k] = true;
                }
            }
        }
    }

    public int[] findPos() {
        for (int i = 0; i < boxContainer.length; i++) {
            for (int j = 0; j < boxContainer[0].length; j++) {
                for (int k = 0; k < boxContainer[0][0].length; k++) {
                    if (!boxContainer[i][j][k]) {
                        return new int[] {i, j, k};
                    }
                }
            }
        }
        return null;
        //no position found
    }
}

