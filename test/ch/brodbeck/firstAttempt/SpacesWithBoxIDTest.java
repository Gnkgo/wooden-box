package ch.brodbeck.firstAttempt;

import ch.brodbeck.firstAttempt.CoordinateSystem;
import org.junit.Test;

public class SpacesWithBoxIDTest {
    @Test
    public void checkSpaceBoxID() {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        coordinateSystem.checkSpacesWithBoxID(3);
    }
}
