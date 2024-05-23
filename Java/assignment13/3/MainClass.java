package Assignment_13_3.threads;

public class MainClass {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread2 thread2=new Thread2();
        myThread.start();
        thread2.start();
    }
}
