

public class MainClass {
    public static void main(String[] args) {
        Threads thread=new Threads();
        Threads thread1=new Threads();
        Threads daemon=new Threads();
        daemon.setDaemon(true);
        daemon.run1(false);
        Threads thread2=new Threads();
        thread.start();
        thread1.start();
        daemon.start();
    }
}