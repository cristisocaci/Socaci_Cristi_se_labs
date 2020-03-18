package edu.tucn.lab4.ex5;

import edu.tucn.lab4.ex1.Circle;

public class Cylinder extends Circle
{
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public double getVolume()
    {
        return super.getArea() * height;
    }

    @Override
    public double getArea() {
        return super.getArea() + 2* Math.PI * getRadius() * height;
    }
}
