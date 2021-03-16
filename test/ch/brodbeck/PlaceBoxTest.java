package ch.brodbeck;

import org.junit.Assert;
import org.junit.Test;

public class PlaceBoxTest {
    @Test
    public void checkPlaceBox(){
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        coordinateSystem.placeBox(0,0, 0, 0);
        //Assert.assertFalse(coordinateSystem.placeBox(0,0,0,3));
    }
}
