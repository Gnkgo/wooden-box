package ch.brodbeck;

import org.junit.Test;

public class SpacesWithBoxIDTest {
    @Test
    public void checkSpaceBoxID() {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        coordinateSystem.checkSpacesWithBoxID(3);
    }
}
