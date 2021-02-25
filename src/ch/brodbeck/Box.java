package ch.brodbeck;

//import java.lang.annotation.Target;

public class Box {
    Box box1 = Boxes[0];
    Box box2 = Boxes[1];
    Box box3 = Boxes[2];
    Box box4 = Boxes[3];
    Box box5 = Boxes[4];
    Box box6 = Boxes[5];
    Box box7 = Boxes[6];
    Box box8 = Boxes[7];
    Box box9 = Boxes[8];
    Box box10 = Boxes[9];
    Box box11 = Boxes[10];

    public static Box TargetBox = new Box(50, 35, 25);
    Box box0 = new Box(15, 15, 15 );

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


    public Box(int length, int width, int height) {
    }
    public boolean checkBox(){
        return box0 == TargetBox;
    }
}
