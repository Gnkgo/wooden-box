package ch.brodbeck;
import static ch.brodbeck.CoordinateSystem.Boxes;

public class Collision extends RotateBox {

    public int getX(int x, int boxID) {
        return x + Boxes[boxID].getWidth();
    }

    public int getY(int y, int boxID) {
        return  y + Boxes[boxID].getLength();
    }

    public int getZ(int z, int boxID) { ;
        return z + Boxes[boxID].getHeight();
    }

    public boolean checkCollision(int givenMinX, int givenMinY, int givenMinZ, int givenBoxID, int minX, int minY, int minZ, int boxID) {
        //Checking whether an AABB intersects another AABB is similar to the point test.
        // We just need to do one test per axis, using the boxes' boundaries.
        // The diagram below shows the test we'd perform over the X-axis — basically,
        // do the ranges AminX–AmaxX and BminX–BmaxX overlap?
        int givenMaxX = getX(givenMinX, givenBoxID);
        int givenMaxY = getY(givenMinY, givenBoxID);
        int givenMaxZ = getZ(givenMinZ, givenBoxID);

        int maxX = getX(minX, boxID);
        int maxY = getY(minY, boxID);
        int maxZ = getZ(minZ, boxID);

        if ((givenMinX < maxX && givenMaxX > minX) &&
                (givenMinY < maxY && givenMaxY > minY) &&
                (givenMinZ < maxZ && givenMaxZ > minZ)) {
            return true;
        }
        return givenBoxID == boxID;
    }
}
