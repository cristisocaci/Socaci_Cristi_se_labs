package edu.tucn.lab11.ex1;


public class Sensor extends Thread{
    double value;
    Display display;

    public Sensor(Display display) {
        this.display = display;
    }

    public void run(){
        for(int i = 0; i < 100; ++i){
            value = Math.random() * 10 + 18;
            display.updateValue((float) (Math.round(value * 100.0) / 100.0));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
