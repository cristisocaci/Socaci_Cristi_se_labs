package edu.tucn.lab5.ex3;

import java.util.Random;

abstract class Sensor {
    private String location;
    public abstract int readValue();

    public String getLocation() {
        return location;
    }
}

class LightSensor extends Sensor {
    @Override
    public int readValue() {
        return new Random().nextInt(100);
    }
}

class TemperatureSensor extends Sensor{
    @Override
    public int readValue() {
        return new Random().nextInt(100);
    }
}

class Controller{
    private LightSensor ls;
    private TemperatureSensor ts;

    public Controller(LightSensor ls, TemperatureSensor ts) {
        this.ls = ls;
        this.ts = ts;
    }

    public void control(){
        for(int i = 0; i < 20; ++i) {
            System.out.println("Temperature: " + ts.readValue() + "\nBrightness: " + ls.readValue());
            try {
                Thread.sleep(1000);
            }catch(InterruptedException ignored){}
        }
    }
}