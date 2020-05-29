package edu.tucn.lab11.ex1;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Sensor sensor = new Sensor(display);
        sensor.start();
    }
}
