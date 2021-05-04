package ch.brodbeck;

import org.junit.Assert;
import org.junit.Test;

public class CollisionTest {
    @Test
    public void checkCollisionTest() {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        Assert.assertFalse(coordinateSystem.checkCollision(0, 0, 0, 4, 6, 3, 4, 1));
        Assert.assertFalse(coordinateSystem.checkCollision(0, 0, 0, 0, 6, 4, 3, 1));
        Assert.assertFalse(coordinateSystem.checkCollision(0, 0, 0, 0, 6, 12, 2, 1));
        Assert.assertFalse(coordinateSystem.checkCollision(0, 0, 0, 1, 6, 4, 3, 1));

        Assert.assertFalse(coordinateSystem.checkCollision(7, 0, 0, 0, 6, 3, 0, 1));
        Assert.assertTrue(coordinateSystem.checkCollision(7, 0, 0, 0, 6, 2, 0, 1));
    }

}
