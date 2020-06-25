package edu.tucn.Examen;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Window extends JFrame {
    Window(){
        super();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new GridLayout(3,1));
        super.setBounds(400, 600, 500, 100);

        JTextArea path = new JTextArea("Enter path here");
        JTextArea text = new JTextArea("Text to write");
        JButton write = new JButton("Write to file");
        write.addActionListener(e->{
            try {
                FileWriter f = new FileWriter(new File(path.getText()), true);
                String s = "\n"+text.getText();
                f.append(s);
                f.close();

                text.setText("Text to write");
                path.setText("Enter path here");
                path.setBackground(null);

            } catch (IOException ex) {
                path.setBackground(Color.RED);
            }

        });

        super.add(path);
        super.add(text);
        super.add(write);

        super.setVisible(true);



    }
}

public class ex1 {
    public static void main(String[] args) {
        Window w = new Window();
    }
}
