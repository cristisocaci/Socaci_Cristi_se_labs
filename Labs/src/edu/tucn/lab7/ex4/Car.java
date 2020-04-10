package edu.tucn.lab7.ex4;

import java.io.*;

public class Car implements Serializable {
    String model;
    int price;

    public Car(String model, int price) {
        this.model = model;
        this.price = price;
    }
    public void SaveCar(){
        try {
            FileOutputStream fileout = new FileOutputStream("src\\edu\\tucn\\lab7\\ex4\\Cars\\"+model+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(this);
            out.close();
            fileout.close();
            System.out.println("Car saved successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
    public static void displayAllCars(){
        File dir = new File("src\\edu\\tucn\\lab7\\ex4\\Cars");
        for(File f: dir.listFiles()){
            System.out.println(f.getName());
        }

    }

    public static Car readModel(String model){
        try {
            FileInputStream fileIn = new FileInputStream("src\\edu\\tucn\\lab7\\ex4\\Cars\\"+model+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Car c = (Car) in.readObject();
            in.close();
            fileIn.close();
            return c;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
