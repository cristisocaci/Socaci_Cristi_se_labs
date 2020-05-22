package edu.tucn.lab10.ex6;

import javax.swing.*;

/**
 * @author Radu Miron
 * @version 1
 */
public class Win extends JFrame {
    private Object monitor;
    private JLabel tf;

    Win(Object monitor) {
        this.monitor = monitor;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(null);

        tf = new JLabel();
        tf.setBounds(110, 10, 280, 20);

        JButton startStop = new JButton("Start/Stop");
        startStop.setBounds(10, 40, 250, 20);
        startStop.addActionListener(e -> {
            synchronized (monitor) {
                monitor.notify();
            }
        });

        add(tf);
        add(startStop);
        setVisible(true);

    }

    public void updateTimer(String val) {
        tf.setText(val);
    }
}
