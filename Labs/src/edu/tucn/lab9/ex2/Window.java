package edu.tucn.lab9.ex2;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private int counter = 0;

    public Window(){
        super("Exercise 2");
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(250, 100);
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(3);
        JButton button = new JButton("Press");
        button.addActionListener(e -> textField.setText( "" + (++counter)) );
        panel.add(textField);
        panel.add(button);
        super.add(panel);
        super.setVisible(true);
    }
}
