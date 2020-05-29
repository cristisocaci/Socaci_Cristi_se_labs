package edu.tucn.lab11.ex1;

import javax.swing.*;

public class Display extends JFrame {
    JLabel value;
    public Display(){
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setBounds(500, 500, 250, 100);
        super.setLayout(null);
        JLabel text = new JLabel("Temperature: ");
        text.setBounds(10, 10, 100, 20);
        text.setVisible(true);
        super.add(text);
        value = new JLabel("0" + " degrees Celsius");
        value.setBounds(90, 10, 150, 20);
        value.setVisible(true);
        super.add(value);

        super.setVisible(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateValue(float value){
        this.value.setText(value + " degrees Celsius");
        super.repaint();
    }
}
