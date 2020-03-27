package edu.tucn.lab5.ex3;

import javax.swing.plaf.synth.ColorType;

public class Main {
    public static void main(String[] args) {
        LightSensor ls = new LightSensor();
        TemperatureSensor ts = new TemperatureSensor();
        Controller c = new Controller(ls, ts);
        c.control();
    }
}
