package edu.tucn.lesson8.game;

import javax.swing.*;
import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Radu Miron
 * @version 1
 */
public class Controller {
    private List<Enemy> enemies;
    private Character mycharacter;
    private boolean collision;
    ArrayList<Integer> speeds = new ArrayList<Integer>();
    Random r = new Random();
    public Controller(List<Enemy> enemies, Character mycharacter) {
        this.enemies = enemies;
        this.mycharacter = mycharacter;
    }

    public int start() {

        int speed = 5;
        calcSpeeds(speed);
        Holder<Integer> count = new Holder<>(1);
        while (!collision) {
            Iterator<Integer> iter = speeds.iterator();
            try {
                enemies.forEach(e -> {
                    e.setLocation(e.getX(), (int) (e.getY() + iter.next()));
                    if(Math.abs(e.getX() - mycharacter.getX()) < Utils.CHARACTER_SIZE){
                        if(Math.abs(e.getY() - mycharacter.getY()) < Utils.CHARACTER_SIZE){
                            collision = true;
                            throw new RuntimeException();
                        }
                    if (e.getY() > Utils.WIN_SIZE) {
                        e.setLocation(r.nextInt(Utils.WIN_SIZE - 20), 0);
                        }
                        if (++count.value % 5 == 0) {
                            calcSpeeds(speed + count.value);
                            throw new RuntimeException();
                        }
                    }
                });
            }
            catch(RuntimeException ignored){
            }


            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {
            }
        }

        return count.value - 1;

    }
    private void calcSpeeds(int mean){

        speeds.clear();
        for (int i = 0; i < enemies.size(); ++i)
            speeds.add(Math.abs((int) (mean + 4 * r.nextGaussian())));
    }
}
