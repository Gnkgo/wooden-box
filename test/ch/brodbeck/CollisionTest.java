package ch.brodbeck;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

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

    @Test
    public void checkRotateBox() {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        Set<Box> result = coordinateSystem.rotateBox(2,3,4);
        Assert.assertEquals(6, result.size());
        Assert.assertTrue(result.contains(new Box(2,3,4)));
        Assert.assertTrue(result.contains(new Box(2,4,3)));
        Assert.assertTrue(result.contains(new Box(3,2,4)));
        Assert.assertTrue(result.contains(new Box(3,4,2)));
        Assert.assertTrue(result.contains(new Box(4,2,3)));
        Assert.assertTrue(result.contains(new Box(4,3,2)));

        result = coordinateSystem.rotateBox(2,2,2);
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(new Box(2,2,2)));
    }

}
