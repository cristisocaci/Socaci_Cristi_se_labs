package edu.tucn.lab10.ex4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Robot extends Thread {
    JLabel img;
    boolean running = true;
    Point p = new Point();
    BoundingBox b;
    Random r = new Random();

    Robot(){
        super();
        this.b = new BoundingBox(p, Utils.characterSize);
        img = new JLabel(new ImageIcon("src\\edu\\tucn\\lab10\\ex4\\robot.jpg"));
        img.setBounds(r.nextInt(Utils.winSize - Utils.characterSize),
                r.nextInt(Utils.winSize - Utils.characterSize), Utils.characterSize, Utils.characterSize);
        img.setVisible(true);

    }
    public void run(){

        while(running){
            int x = r.nextInt(Utils.winSize - Utils.characterSize);
            int y = r.nextInt(Utils.winSize - Utils.characterSize);
            p.setXY(x,y);
            System.out.println("" + x + "," + y);
            img.setLocation(p.x, p.y);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    BoundingBox getBoundingBox(){
        return b;
    }
    boolean testCollision(Robot b){
        return this.getBoundingBox().testCollision(b.getBoundingBox());
    }
    JLabel getLabel(){
        return img;
    }

    void stopTh(){
        img.setVisible(false);
        running = false;
    }
}
