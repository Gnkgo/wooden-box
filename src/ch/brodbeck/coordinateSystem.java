package ch.brodbeck;

public class coordinateSystem {
    public int[] xAxis = new int[51];
    public int[] yAxis = new int[36];
    public int[] zAxis = new int[26];
    /*
    height = z
    length = y
    width = x
     */
    public static Box TargetBox = new Box(50, 35, 25);
    public static Box[] Boxes = new Box[] {
            // Cubes
            new Box(15, 15, 15),
            new Box(20, 20, 20),
            // Flat planks
            new Box(20, 15, 5),
            new Box(25, 20, 5),
            new Box(30, 15, 5),
            new Box(35, 15, 5),
            new Box(50, 15, 5),
            // Thick planks
            new Box(20, 15, 10),
            new Box(30, 15, 10),
            new Box(35, 15, 10),
            new Box(35, 20, 10),
    };

    public void checkPossibility() {
    }

    public void boxLeft() {
    }

    public boolean checkCollision(int x, int y, int z) {
        return xAxis[x] != -1 || yAxis[y] != -1 || zAxis[z] != -1;
        //get collision with corners of the box
    }

    public void placeBox(int x, int y, int z, int j){
        setPosition(x, y, z);
        checkCollision(x, y, z);
        for (int i = 0; i < Boxes[j].getWidth(); i++) {
            xAxis [x] = -1;
            /*
            exception when array is too short,
            then this combination doesn't work,
            either rotate Box or choose another combination
             */
        }
        for (int i = 0; i < Boxes[j].getLength(); i++) {
            yAxis [x] = -1;
        }
        for (int i = 0; i < Boxes[j].getHeight(); i++) {
            zAxis [x] = -1;
        }
    }

    public void getLeftCorner(int x, int y, int z) {
        setPosition(x, y, z);
        int[] leftBottomCorner = {xAxis [x], yAxis [y], xAxis [y],};
        }

    public void getRightCorner(int x, int y, int z, int j) {
        int[] rightTopCorner = {
                xAxis [x] + Boxes [j].getWidth(),
                yAxis [y] + Boxes [j].getLength(),
                xAxis [y] + Boxes [j].getHeight(),
        };
    }//one method? getLeftCorner and getRightCorner? Mapping? Pair?

    public void setPosition(int x, int y, int z) {
        xAxis [x] = -1;
        yAxis [y] = -1;
        zAxis [z] = -1;
    }

    public void rotateLengthWidth(int length, int width) {
        int a = width;
        width = length;
        length = a;
    }

    public void rotateLengthHeight(int length, int height) {
        int a = height;
        height = length;
        length = a;
    }

    public void rotateHeightWidth(int height, int width) {
        int a = height;
        height = width;
        width = a;

    }
}

