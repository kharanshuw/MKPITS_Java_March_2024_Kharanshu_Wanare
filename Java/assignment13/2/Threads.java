package Assignment_13_2;

public class Threads extends Thread implements Runnable {
    public synchronized void run(){
        System.out.println("Thread Running....");
    }
    public void run1(boolean t){
        System.out.println("Daemon Thread Running....");
    }
}