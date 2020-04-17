package edu.tucn.lab8.ex4;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

abstract class Sensor{
    public abstract Event getEvent();
}

abstract class Unit{
    public abstract void start();
}

class TemperatureSensor extends Sensor{

    int value;
    @Override
    public Event getEvent() {
        value = new Random().nextInt(40);
        return new TemperatureEvent(value);
    }
}

class FireSensor extends Sensor{

    int fire;
    boolean smoke;
    @Override
    public Event getEvent() {
        Random rand = new Random();
        fire = rand.nextInt(10); // 10% chance of fire
        if(fire == 0) {
            smoke = rand.nextInt(2) == 1;
            return new FireEvent(smoke);
        }
        else
            return new NoEvent();
    }
}

class ControlUnit extends Unit{
    private static ControlUnit controlUnit;
    private int minTemperature, maxTemperature;
    private TemperatureSensor temperatureSensor = new TemperatureSensor();
    private ArrayList<FireSensor> fireSensors = new ArrayList<FireSensor>();
    private AlarmUnit alarmUnit = new AlarmUnit();
    private HeatingUnit heatingUnit = new HeatingUnit();
    private CoolingUnit coolingUnit = new CoolingUnit();
    private GSMUnit gsmUnit = new GSMUnit();
    private Logger log;

    static ControlUnit getControlUnit(){
        if(controlUnit == null)
            controlUnit = new ControlUnit(20, 25);
        return controlUnit;
    }

    private ControlUnit(int minTemperature, int maxTemperature) {
        try {
            FileHandler handler = new FileHandler("src\\edu\\tucn\\lab8\\ex4\\controlLog.log", false);
            log = Logger.getLogger("edu.tucn.lab8.ex4");
            log.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
            log.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 3; ++i)
            fireSensors.add(new FireSensor());

        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;

        log.info("Control Unit initialized");
    }

    @Override
    public void start() {
        for(int i = 0; i < 5; ++i){
            System.out.println("Reading #" + (i+1));
            log.info("Reading #" + (i+1));
            TemperatureEvent tevent = (TemperatureEvent) temperatureSensor.getEvent();

            boolean fire = false;
            int count = 1;
            for(Sensor fireSensor: fireSensors) {
                Event fevent = fireSensor.getEvent();

                if (fevent.getType() == EventType.FIRE) {
                    System.out.println("Fire Sensor #"+count +": detected fire");
                    log.warning("Fire Sensor #"+count +": detected fire \nAlarm started... \nCalling the owner...");
                    alarmUnit.start();
                    gsmUnit.start();
                    fire = true;
                }
                else{
                    System.out.println("Fire Sensor #"+count +": no fire");
                    log.info("Fire Sensor #"+count +": no fire");
                }
                ++count;
            }
            if(!fire) {
                System.out.println("Temperature sensor: " + tevent.getVlaue() + " degrees");
                log.info("Temperature sensor: " + tevent.getVlaue() + " degrees");
                if (tevent.getVlaue() > maxTemperature){
                    log.info("Cooling system started");
                    coolingUnit.start();
                }
                else if (tevent.getVlaue() < minTemperature) {
                    log.info("Heating system started");
                    heatingUnit.start();
                }
            }

        }
    }
}

class AlarmUnit extends Unit{

    @Override
    public void start() {
        System.out.println("Alarm activated");
    }
}

class HeatingUnit extends Unit{

    @Override
    public void start() {
        System.out.println("Start heating the room");
    }
}

class CoolingUnit extends Unit{

    @Override
    public void start() {
        System.out.println("Cooling the room");
    }
}

class GSMUnit extends Unit{

    @Override
    public void start() {
        System.out.println("Calling the owner");
    }
}
