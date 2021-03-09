package ch.brodbeck;

public class coordinateSystem {
    public int[][][] coordinate = new int[51][36][26];
    public int xNumberl;
    public int yNumberl;
    public int zNumberl;
    public int xNumberr;
    public int yNumberr;
    public int zNumberr;
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

    public boolean checkCollision(int givenX, int givenY, int givenZ, int givenJ, int x, int y, int z, int j) {

        if ((getLeftCorner(x, y, z)[0] > getLeftCorner(givenX, givenY, givenZ)[0]) &&
                (getLeftCorner(x, y, z)[0]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[0])) {
            return false;
        } else if ((getLeftCorner(x, y, z)[1] > getLeftCorner(givenX, givenY, givenZ)[1]) &&
                (getLeftCorner(x, y, z)[1]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[1])) {
            return false;
        } else if ((getLeftCorner(x, y, z)[2] > getLeftCorner(givenX, givenY, givenZ)[2]) &&
                (getLeftCorner(x, y, z)[2]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[2])) {
            return false;
        }else if ((getRightCorner(x, y, z, j)[0] > getLeftCorner(givenX, givenY, givenZ)[0]) &&
                (getRightCorner(x, y, z, j)[0]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[0])) {
            return false;
        } else if ((getLeftCorner(x, y, z)[1] > getLeftCorner(givenX, givenY, givenZ)[1]) &&
                (getRightCorner(x, y, z, j)[1]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[1])) {
            return false;
        } else if ((getLeftCorner(x, y, z)[2] > getLeftCorner(givenX, givenY, givenZ)[2]) &&
                (getRightCorner(x, y, z, j)[2]) < (getRightCorner(givenX, givenY, givenZ, givenJ)[2])) {
            return false;
        } else {
            return true;
        }
        //get collision with corners of the box
    }

    public void placeBox(int x, int y, int z, int j){
        getRightCorner(x, y, z, j)[0] = xNumberl;
        checkCollision(x, y, z, j);
        coordinate [x][y][z]
        for (int i = 0; i < Boxes[j].getWidth(); i++) {
            coordinate [i][y][z] = -1;
            for (int h = 0; j < Boxes[h].getLength(); h++) {
                coordinate [x][h][z] = -1;
            }
                for (int k = 0; k < Boxes[j].getHeight(); k++) {
                    coordinate [x][y][k] = -1;
                }
            /*
            exception when array is too short,
            then this combination doesn't work,
            either rotate Box or choose another combination
             */


        }

    }
    public int[] getLeftCorner(int x, int y, int z) {
        xNumberl = x;
        yNumberl = y;
        zNumberl = z;
        return new int[]{x, y, z};
    }

    public int[] getRightCorner(int x, int y, int z, int j) {
        int[] rightTopCorner = {
                coordinate
                        [x + Boxes [j].getWidth()]
                        [y + Boxes [j].getLength()]
                        [z + Boxes [j].getHeight()]
        };
        /*
        xNumberr += Boxes [j].getWidth();
        yNumberr += Boxes [j].getLength();
        zNumberr += Boxes [j].getHeight();
         */
        return rightTopCorner;
    }//one method? getLeftCorner and getRightCorner? Mapping? Pair?

    public void setPosition(int x, int y, int z) {
        coordinate [x][y][z] = -1;
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

