package edu.tucn.lab4.ex6;

public class Main
{
    public static void main(String[] args) {
        Shape s = new Shape("black", false);
        System.out.println(s.toString());
        Circle c = new Circle(2, "black", true);
        System.out.println(c.toString());
        Rectangle r = new Rectangle(2, 2, "blue" , false);
        System.out.println(r.toString());
        Square sq = new Square(5, "magenta", true);
        System.out.println(sq.toString());

    }
}
