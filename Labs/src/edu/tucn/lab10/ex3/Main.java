package edu.tucn.lab10.ex3;

import java.util.Currency;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Counter c1 = new Counter(0, 10, semaphore);
        Counter c2 = new Counter(10, 20, semaphore);
        Counter c3 = new Counter(20, 30, semaphore);
        Counter c4 = new Counter(30, 40, semaphore);
        c1.start();
        Thread.sleep(50);
        c2.start();
        Thread.sleep(50);
        c3.start();
        Thread.sleep(50);
        c4.start();
    }
}

class Counter extends Thread {
    private int start;
    private int end;
    private Semaphore semaphore;

    public Counter(int start, int end, Semaphore semaphore) {
        this.start = start;
        this.end = end;
        this.semaphore = semaphore;
    }

    public void run() {

        try {
            semaphore.acquire();
            for (int i = start; i < end; ++i) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

    }
}


