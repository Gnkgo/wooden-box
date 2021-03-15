package ch.brodbeck;

import org.junit.Assert;
import org.junit.Test;

public class CollisionTest {
    @Test
    public void checkCollisionTest() {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        Assert.assertFalse(coordinateSystem.checkCollision(0, 0, 0, 4, 29, 16, 6, 1));

    }

}
