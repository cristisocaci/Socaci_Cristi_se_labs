package edu.tucn.lab5.ex1;

public class TestShape {
    private Shape[] shapes;

    public TestShape(Shape[] shapes) {
        this.shapes = shapes;
    }
    public void startTest(){
        for(Shape s: shapes){
            System.out.println(s.toString());
            System.out.println("Area: " + s.getArea());
            System.out.println("Perimeter: " + s.getPerimeter());
        }
    }
}
