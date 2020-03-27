package edu.tucn.lab5.ex3;

import java.util.Random;

public class LightSensor extends Sensor {
    @Override
    public int readValue() {
        return new Random().nextInt(100);
    }
}
