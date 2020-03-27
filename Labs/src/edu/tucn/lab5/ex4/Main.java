package edu.tucn.lab5.ex4;

import edu.tucn.lab5.ex3.LightSensor;
import edu.tucn.lab5.ex3.TemperatureSensor;

public class Main {
    public static void main(String[] args) {
        LightSensor ls = new LightSensor();
        TemperatureSensor ts = new TemperatureSensor();
        Controller c = Controller.getController(ls, ts);
        Controller c2 = Controller.getController(ls, ts);
        System.out.println(c == c2);
    }
}
