package ch.brodbeck.fastSolver;

import java.util.Arrays;

public class JonasSolver {

    public static void main(String args[]) {
        // Create objects
        boolean[][][] container = new boolean[10][7][5];
        int[][] boxes = new int[11][3];
        boolean[] used = new boolean[11];
        boxes[0] = new int[]{3, 3, 3};
        boxes[1] = new int[]{4, 4, 4};
        boxes[2] = new int[]{4, 3, 1};
        boxes[3] = new int[]{5, 4, 1};
        boxes[4] = new int[]{6, 3, 1};
        boxes[5] = new int[]{7, 3, 1};
        boxes[6] = new int[]{10, 3, 1};
        boxes[7] = new int[]{4, 3, 2};
        boxes[8] = new int[]{6, 3, 2};
        boxes[9] = new int[]{7, 3, 2};
        boxes[10] = new int[]{7, 4, 2};

        // Calculate result
        long timeStart = System.currentTimeMillis();
        rec(container, boxes, used, 0);
        long timeEnd = System.currentTimeMillis();
        System.out.println("The calculation took " + 1.0 * (timeEnd - timeStart) / 1000 + " seconds.");
    }

    public static boolean rec(boolean[][][] container, int[][] boxes, boolean[] used, int depth) {
        // Check if the recursion is done
        if (depth == 11) {
            System.out.println("Solution found:");
            return true;
        }

        // Find lowest possible position with low x, low y, low z
        int xl = 0;
        int yl = 0;
        int zl = 0;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 7; y++) {
                for (int z = 0; z < 5; z++) {
                    if (container[x][y][z] == false) {
                        xl = x;
                        yl = y;
                        zl = z;
                        x = 100;
                        y = 100;
                        z = 100;
                    }
                }
            }
        }

        // Itterate through boxes
        for (int i = 0; i < 11; i++) {
            if (depth == 0) {
                System.out.println("Starting with box number " + i);
            }
            if (!used[i]) {
                used[i] = true;
                // Try every rotation of the box
                for (int p = 0; p < 6; p++) {
                    int x = 0;
                    int y = 0;
                    int z = 0;
                    if (p == 0) {
                        x = boxes[i][0];
                        y = boxes[i][1];
                        z = boxes[i][2];
                    } else if (p == 1) {
                        x = boxes[i][0];
                        z = boxes[i][1];
                        y = boxes[i][2];
                    } else if (p == 2) {
                        y = boxes[i][0];
                        x = boxes[i][1];
                        z = boxes[i][2];
                    } else if (p == 3) {
                        y = boxes[i][0];
                        z = boxes[i][1];
                        x = boxes[i][2];
                    } else if (p == 4) {
                        z = boxes[i][0];
                        x = boxes[i][1];
                        y = boxes[i][2];
                    } else {
                        z = boxes[i][0];
                        y = boxes[i][1];
                        x = boxes[i][2];
                    }

                    // Check if we can place the box
                    boolean placeable = true;
                    for (int l = xl; l < xl + x; l++) {
                        for (int j = yl; j < yl + y; j++) {
                            for (int k = zl; k < zl + z; k++) {
                                if (l >= 10 || j >= 7 || k >= 5 || container[l][j][k] == true) {
                                    placeable = false;
                                    k = 100;
                                    j = 100;
                                    l = 100;
                                }
                            }
                        }
                    }

                    // Place box if its placeable
                    if (placeable) {
                        for (int l = xl; l < xl + x; l++) {
                            for (int j = yl; j < yl + y; j++) {
                                for (int k = zl; k < zl + z; k++) {
                                    container[l][j][k] = true;
                                }
                            }
                        }
                        // run recursion
                        if ((rec(container, boxes, used, depth + 1))) {
                            System.out.println(x + ", " + y + ", " + z + ", at " + xl + ", " + yl + ", " + zl);
                            return true;
                        }
                    }

                    // Remove box if it was placed
                    if (placeable) {
                        for (int l = xl; l < xl + x; l++) {
                            for (int j = yl; j < yl + y; j++) {
                                for (int k = zl; k < zl + z; k++) {
                                    container[l][j][k] = false;
                                }
                            }
                        }
                    }
                }
                used[i] = false;
            }
        }
        return false;
    }
}

