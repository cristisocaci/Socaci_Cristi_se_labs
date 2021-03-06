package edu.tucn.lesson8.game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;

/**
 * @author Radu Miron
 * @version 1
 */
public class MainWindow extends JFrame {

    private Character character;
    private List<Enemy> enemies;
    private Integer[] score;

    MainWindow(Character character, List<Enemy> enemies, Integer[] score) {
        super("My Beautiful Game");
        this.setLayout(null);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.enemies = enemies;
        this.character = character;
        this.character.setLocation(240, 420);
        this.score = score;

        JLabel scoreLabel = new JLabel("Score: " + this.score[0]);
        scoreLabel.setBounds(20, 20, 100, 10);
        scoreLabel.setVisible(true);
        this.add(scoreLabel);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'a') {
                    if (character.getX() <= 0)
                        character.setLocation(0, character.getY());
                    else
                        character.setLocation(character.getX() - 5, character.getY());
                } else if (e.getKeyChar() == 'd') {
                    if (character.getX() >= Utils.WIN_SIZE - Utils.CHARACTER_SIZE)
                        character.setLocation(Utils.WIN_SIZE - Utils.CHARACTER_SIZE, character.getY());
                    else
                        character.setLocation(character.getX() + 5, character.getY());
                }
                scoreLabel.setText("Score: " + score[0]);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setSize(Utils.WIN_SIZE, Utils.WIN_SIZE);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(this.character);

        int[] c = {0};
        Random r = new Random();
        enemies.forEach(e -> {
            e.setLocation(r.nextInt(Utils.WIN_SIZE - Utils.CHARACTER_SIZE), 0);
            MainWindow.this.add(e);
            c[0] += 1;
        });

        setVisible(true);
    }

    public void setInvisible() {
        character.setVisible(false);
        enemies.forEach(e -> e.setVisible(false));
    }
}
