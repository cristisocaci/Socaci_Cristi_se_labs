package edu.tucn.lab8.ex4;

import java.util.Random;

public class Main {

    public static void main(String[] args){
        Home home = new Home();
        home.startMonitoring();
    }
}

class Home {
    ControlUnit controlUnit;
    public Home(){
        controlUnit = ControlUnit.getControlUnit();
    }
    public void startMonitoring(){
        controlUnit.start();
    }
}

abstract class Event {

    EventType type;

    Event(EventType type) {
        this.type = type;
    }

    EventType getType() {
        return type;
    }

}

class TemperatureEvent extends Event {

    private int vlaue;

    TemperatureEvent(int vlaue) {
        super(EventType.TEMPERATURE);
        this.vlaue = vlaue;
    }

    int getVlaue() {
        return vlaue;
    }

    @Override
    public String toString() {
        return "TemperatureEvent{" + "vlaue=" + vlaue + '}';
    }

}

class FireEvent extends Event {

    private boolean smoke;

    FireEvent(boolean smoke) {
        super(EventType.FIRE);
        this.smoke = smoke;
    }

    boolean isSmoke() {
        return smoke;
    }

    @Override
    public String toString() {
        return "FireEvent{" + "smoke=" + smoke + '}';
    }

}

class NoEvent extends Event{

    NoEvent() {
        super(EventType.NONE);
    }

    @Override
    public String toString() {
        return "NoEvent{}";
    }
}

enum EventType {
    TEMPERATURE, FIRE, NONE;
}