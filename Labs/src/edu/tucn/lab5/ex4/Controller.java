package edu.tucn.lab5.ex4;
import edu.tucn.lab5.ex3.*;

public class Controller {
    private LightSensor ls;
    private TemperatureSensor ts;
    private static Controller controller;

    private Controller(LightSensor ls, TemperatureSensor ts) {
        this.ls = ls;
        this.ts = ts;
    }

    public static Controller getController(LightSensor ls, TemperatureSensor ts){
        if(controller == null)
            controller = new Controller(ls, ts);
        else
            System.out.println("Returning the same controller");
        return controller;
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
