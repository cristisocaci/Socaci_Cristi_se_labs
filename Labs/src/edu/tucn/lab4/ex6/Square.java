package edu.tucn.lab4.ex6;

public class Square extends Rectangle
{
    public Square() {
    }
    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide(){
        return getLength();
    }

    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setWidth(width);
        setLength(width);
    }

    @Override
    public void setLength(double length) {
        setWidth(length);
        setLength(length);
    }

    @Override
    public String toString() {
        return "A Square with side = " + getLength() + ", which is a subclass of " + super.toString();
    }
}
