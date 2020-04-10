package edu.tucn.lab7.ex4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Car car = null;
        boolean running = true;

        while(running){
            System.out.println("Enter an action: ");
            System.out.println("1.Create car");
            System.out.println("2.Save car");
            System.out.println("3.View all saved cars");
            System.out.println("4.Retrieve a car");
            System.out.println("0.Exit");
            int choice = in.nextInt();
            switch(choice){
                case 0:
                    running = false;
                    in.close();
                    break;
                case 1:
                    car = createCar();
                    break;
                case 2:
                    saveCar(car);
                    break;
                case 3:
                    viewSavedCars();
                    break;
                case 4:
                    readCar();
                    break;
            }
        }
    }

    private static Car createCar(){
        System.out.print("Enter car model: ");
        String model = in.next();
        System.out.print("Enter price: ");
        int price = in.nextInt();
        return new Car(model, price);
    }

    private static void saveCar(Car car){
        if (car != null)
            car.SaveCar();
        else
            System.out.println("Create a car first");
    }
    private static void viewSavedCars(){
        Car.displayAllCars();
    }
    private static void readCar(){
        System.out.print("Enter car model: ");
        String model = in.next();
        Car c = Car.readModel(model);
        if (c != null)
            System.out.println(c.toString());
        else
            System.out.println("Car not found");
    }
}
