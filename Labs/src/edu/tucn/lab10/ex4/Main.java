package edu.tucn.lab10.ex4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Window w = new Window();
        ArrayList<Robot> robot = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; ++i) {
            robot.add(new Robot());
            w.add(robot.get(i).getLabel());
            robot.get(i).start();
        }
        w.setVisible(true);
        while (size > 1) {
            for (int i = 0; i < size; ++i) {
                for (int j = i + 1; j < size; ++j) {
                    if (robot.get(i).testCollision(robot.get(j))) {
                        robot.get(i).stopTh();
                        robot.get(j).stopTh();
                        robot.remove(j);
                        robot.remove(i);
                        size -= 2;
                        Thread.sleep(500);
                    }
                }
            }
            System.out.println(size);
            w.repaint();
            Thread.sleep(1000);
        }
    }
}
