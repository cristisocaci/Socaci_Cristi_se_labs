package edu.tucn.lab10.ex6;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Object monitor = new Object();

        Win win = new Win(monitor);

        TimerThread timerThread = new TimerThread(monitor, win);
        timerThread.start();
    }
}
