package ch.brodbeck;

import org.junit.Test;

public class DeleteBoxTest {
    @Test
    public void checkDeleteBox() {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        //coordinateSystem.placeBox(0, 0, 0, 0);
        coordinateSystem.placeBox(2,2,2,2);
        coordinateSystem.deleteBox(2);
    }
}
