package ch.brodbeck;

public class Main {
    public static Box TargetBox = new Box(50, 35, 25);
    public static Box[] Boxes = new Box[] {
            // Cubes
            new Box(15, 15, 15),
            new Box(20, 20, 20),
            // Flat planks
            new Box(20, 15, 5),
            new Box(25, 20, 5),
            new Box(30, 15, 5),
            new Box(35, 15, 5),
            new Box(50, 15, 5),
            // Thick planks
            new Box(20, 15, 10),
            new Box(30, 15, 10),
            new Box(35, 15, 10),
            new Box(35, 20, 10),
    };
    public static void main(String[] args) {
	    int expectedVolume = TargetBox.volume();
	    System.out.println(expectedVolume);
	    System.out.println(combinedVolume());
    }
    public static int combinedVolume() {
        int endVolume = 0;
        for (int i = 0; i < Boxes.length; i++){
            endVolume += Boxes[i].volume();
        }
        return endVolume;
    }
}
