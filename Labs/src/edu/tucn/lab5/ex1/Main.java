package edu.tucn.lab5.ex1;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("red", true, 2);
        shapes[1] = new Rectangle("blue", false, 5, 7);
        shapes[2] = new Square("magenta", true, 9);

        TestShape test = new TestShape(shapes);
        test.startTest();
    }
}
