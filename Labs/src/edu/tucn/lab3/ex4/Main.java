package edu.tucn.lab3.ex4;

class MyPoint
{
    private int x;
    private int y;

    public MyPoint()
    {
        x = 0;
        y = 0;
    }
    public MyPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public String toString() {
        return '(' + String.valueOf(x) + ',' + String.valueOf(y) + ')';
    }

    public double distance(int x, int y)
    {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance(MyPoint p)
    {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }
}

class TestPoint
{
    MyPoint p;
    MyPoint q;
    public TestPoint()
    {
        p = new MyPoint(2,3);
        q = new MyPoint();
    }
    public  void test()
    {
        System.out.println("" + p.getX() + " " + p.getY());
        q.setX(-1);
        q.setY(-1);
        System.out.println(q.toString());
        System.out.println(p.distance(q));
        System.out.println(p.distance(3,3));
    }
}

public class Main {
    public static void main(String[] args) {
        TestPoint t = new TestPoint();
        t.test();
    }
}
