package edu.tucn.lab10.ex6;

/**
 * @author Radu Miron
 * @version 1
 */
public class TimerThread extends Thread {
    private Object monitor;
    private Win win;

    public TimerThread(Object monitor, Win win) {
        this.monitor = monitor;
        this.win = win;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
            }

            long t1 = System.currentTimeMillis();

            try {
                monitor.wait();
            } catch (InterruptedException e) {
            }

            long t2 = System.currentTimeMillis();

            win.updateTimer(t2 - t1);
        }

    }
}
