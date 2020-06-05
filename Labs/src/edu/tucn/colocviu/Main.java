package edu.tucn.colocviu;


import javax.swing.*;
import java.awt.*;

class Win extends JFrame {
        Win(){
            setBounds(700, 400, 150, 200);
            setLayout(new GridLayout(4, 1));
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            JTextField nb1 = new JTextField();
            JTextField nb2 = new JTextField();
            JTextField result = new JTextField();
            result.setEditable(false);
            JButton execute = new JButton("Add");
            execute.addActionListener(e->{
                int aux = Integer.parseInt(nb1.getText()) + Integer.parseInt(nb2.getText());
                result.setText(""+aux);
                nb1.setText("");
                nb2.setText("");
            });


            add(nb1);
            add(nb2);
            add(result);
            add(execute);

            setVisible(true);
        }
}


public class Main {
    public static void main(String[] args) {
        Win win = new Win();
    }
}
