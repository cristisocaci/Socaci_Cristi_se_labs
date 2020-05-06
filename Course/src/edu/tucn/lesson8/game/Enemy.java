package edu.tucn.lesson8.game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Radu Miron
 * @version 1
 */
public class Enemy extends JComponent {
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, Utils.CHARACTER_SIZE, Utils.CHARACTER_SIZE);
    }
}
