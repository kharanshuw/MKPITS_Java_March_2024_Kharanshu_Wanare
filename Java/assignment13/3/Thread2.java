package Assignment_13_3.threads;

public class Thread2 extends Thread {
    public void run() {
        while (true) {
            System.out.println(Thread2.currentThread().getName());
            Thread2.currentThread().setName("yash");
            try {
                Thread2.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
