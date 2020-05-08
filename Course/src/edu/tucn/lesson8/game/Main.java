package edu.tucn.lesson8.game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Character character = new Character();
        character.setSize(Utils.CHARACTER_SIZE, Utils.CHARACTER_SIZE);

        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Enemy enemy = new Enemy();
            enemy.setSize(Utils.CHARACTER_SIZE, Utils.CHARACTER_SIZE);
            enemies.add(enemy);
        }
        Integer[] score = new Integer[1];
        score[0] = 0;
        MainWindow window = new MainWindow(character, enemies, score);
        //JLabel youlose= new JLabel(new ImageIcon("src\\edu\\tucn\\lesson8\\game\\youlose.jpg"));
        JPanel youlose = new JPanel();
        youlose.setBackground(Color.BLACK);
        youlose.setBounds(0, 0, 500, 510);
        youlose.setVisible(false);
        JTextArea text = new JTextArea("   YOU LOSE\nFINAL SCORE");
        text.setBackground(Color.BLACK);
        text.setBounds(0, 100, 400, 300);
        text.setFont(new Font("AppleGothic", Font.PLAIN, 48));
        text.setDisabledTextColor(Color.white);
        text.setVisible(true);
        youlose.add(text);
        window.add(youlose);

        text.setText(text.getText() + "\n          " + new Controller(enemies, character, score).start());
        window.setInvisible();
        youlose.setVisible(true);


    }
}
