package threads;

public class Mythread3 implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
