package Assignment_13_3.threads;

public class MyThread extends Thread implements Runnable {
    public void run() {
        while (true) {
            System.out.println(MyThread.currentThread().getName());
            //using setName method to set the name of the thread
            Thread.currentThread().setName("Shreyash");
            try {
                MyThread.sleep(1000);// sleep() method to stop the working of the thread for a time
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}