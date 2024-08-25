package threads;

public class MyThread2 implements Runnable {


//	public void run() {
//		System.out.println("inside thread2 ");		
//	}
//	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		Thread xThread=Thread.currentThread();
//		
//		System.out.println(xThread.getName());
//		
//	}
	
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
