package edu.tucn.lab9.ex3;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Window extends JFrame {
    private String path;

    public Window(){
        super("Exercise 2");

        JTextField textField = new JTextField(500);
        textField.setMaximumSize(new Dimension(500, 100));
        add(textField);

        JTextArea textArea = new JTextArea();
        JButton button = new JButton("Show Contents");
        button.addActionListener(e -> {
            path = textField.getText();
            try {
                BufferedReader f = new BufferedReader(new FileReader(path));
                StringBuilder sb = new StringBuilder();
                String line;
                while( (line = f.readLine()) != null){
                    sb.append(line).append('\n');
                }
                textArea.setText(String.valueOf(sb));
            } catch (FileNotFoundException ex) {
                textArea.setText("No such file");
            } catch (IOException ex) {
                textArea.setText("Exception");
            }


        });
        add(button);
        add(textArea);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
}
