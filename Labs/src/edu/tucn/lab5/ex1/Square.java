package edu.tucn.lab5.ex1;

public class Square extends Rectangle{
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String colour, boolean filled, double side) {
        super(colour, filled, side, side);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }
    @Override
    public String toString() {
        return "Square{" +
                "side=" + super.getWidth() +
                '}';
    }
}
