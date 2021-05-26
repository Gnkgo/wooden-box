package ch.brodbeck.firstAttempt;

import ch.brodbeck.firstAttempt.CoordinateSystem;
import org.junit.Assert;
import org.junit.Test;

public class CollisionTest {
    @Test
    public void checkCollisionTest() {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        Assert.assertTrue(coordinateSystem.checkCollision(0, 0, 0, 0, 2, 2, 2, 2));
        Assert.assertTrue(coordinateSystem.checkCollision(3, 4, 4, 0, 4, 4, 4, 2));
        Assert.assertFalse(coordinateSystem.checkCollision(0, 0, 0, 0, 4, 4, 4, 1));
        Assert.assertFalse(coordinateSystem.checkCollision(0, 0, 0, 0, 3, 3, 3, 1));
    }
}
