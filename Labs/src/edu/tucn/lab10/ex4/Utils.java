package edu.tucn.lab10.ex4;

class Utils {
    public static final int winSize = 1000;
    public static final int characterSize = 100;
}

class Point{
    int x = 0;
    int y = 0;
    Point(){}
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

}

class BoundingBox{
    Point p;
    int size;

    public BoundingBox(Point p, int size) {
        this.p = p;
        this.size = size;
    }

    boolean testCollision(BoundingBox b){
        return (Math.abs(this.p.x - b.p.x) <= this.size) && (Math.abs(this.p.y - b.p.y) <= this.size);
    }

    void setPosition(Point p){
        this.p = p;
    }
}