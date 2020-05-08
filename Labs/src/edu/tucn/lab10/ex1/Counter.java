package edu.tucn.lab10.ex1;

public class Counter extends Thread {

    Counter(String name){
        super(name);
    }

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(getName() + " i = "+i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " job finalised.");
    }

    public static void main(String[] args) {
        Counter c1 = new Counter("counter1");
        Counter c2 = new Counter("counter2");
        Counter c3 = new Counter("counter3");

        c1.run();
        c2.start();
        c3.start();
    }
}