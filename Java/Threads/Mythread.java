package threads;

//this is example of class which extends thread class and create thread
public class Mythread extends Thread {
//	@Override
//	public void run() {
//		System.out.println("hello");
//	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}
}
