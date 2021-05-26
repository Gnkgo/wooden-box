package ch.brodbeck.firstAttempt;

import ch.brodbeck.firstAttempt.CoordinateSystem;
import org.junit.Test;

public class PlaceBoxTest {
    @Test
    public void checkPlaceBox(){
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        coordinateSystem.placeBox(2,2, 2, 0);
        //Assert.assertFalse(coordinateSystem.placeBox(0,0,0,3));
    }
}
