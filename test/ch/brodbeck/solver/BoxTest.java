package ch.brodbeck.solver;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class BoxTest {
    @Test
    public void checkRotateBox() {
        Box a = new Box(2,3,4);
        Set<Box> result = a.getAllRotations();
        Assert.assertEquals(6, result.size());
        Assert.assertTrue(result.contains(new Box(2,3,4)));
        Assert.assertTrue(result.contains(new Box(2,4,3)));
        Assert.assertTrue(result.contains(new Box(3,2,4)));
        Assert.assertTrue(result.contains(new Box(3,4,2)));
        Assert.assertTrue(result.contains(new Box(4,2,3)));
        Assert.assertTrue(result.contains(new Box(4,3,2)));

        a = new Box (2,2,2);
        result = a.getAllRotations();
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(new Box(2,2,2)));
    }
}
