package ch.brodbeck;

import java.util.HashSet;
import java.util.Set;

public class RotateBox extends PlaceBox{
    @SuppressWarnings("SuspiciousNameCombination")
    public Set<Box> rotateBox(int length, int width, int height) {
        Set<Box> hashSet = new HashSet<Box>();
        hashSet.add(new Box(length, width, height));
        hashSet.add(new Box(length, height, width));
        hashSet.add(new Box(height, width, length));
        hashSet.add(new Box(height, length, width));
        hashSet.add(new Box(width, height, length));
        hashSet.add(new Box(width, length, height));
        return hashSet;
    }
}
