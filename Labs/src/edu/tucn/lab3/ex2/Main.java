package edu.tucn.lab3.ex2;

import java.util.Random;

class Circle
{
    private double radius = 1.0;
    private String colour = "red";

    public Circle(double r)
    {
        this.radius = r;
    }
    public Circle(double r, String s)
    {
        this.radius = r;
        this.colour = s;
    }

    public double getRadius()
    {
        return this.radius;
    }
    public  double getArea()
    {
        return Math.PI * Math.pow(this.radius, 2);
    }
}

class TestCircle
{
    private Circle c;
    public void test()
    {
        Random rand = new Random();
        for(int i = 0; i < 10; ++i)
        {
            this.c = new Circle(rand.nextDouble());
            System.out.println(this.c.getRadius() + " " + this.c.getArea());
        }
    }

}
public class Main
{
    public static void main(String[] args) {
        TestCircle t = new TestCircle();
        t.test();
    }
}
