package ch.brodbeck.firstAttempt;

import ch.brodbeck.firstAttempt.CoordinateSystem;
import ch.brodbeck.solver.Box;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class RotateBoxTest {
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
