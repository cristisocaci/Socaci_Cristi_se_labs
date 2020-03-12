package edu.tucn.lab3.ex2;

import javax.swing.*;

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
    public TestCircle(Circle c)
    {
        this.c = c;
    }
    
}
public class Main
{
    public static void main(String[] args) {

    }
}
