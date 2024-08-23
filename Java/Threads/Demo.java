package threads;

public class Demo {
	public static void main(String[] args) {
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i=i+2) {
					System.out.println(i);
					
				}
			}
		};
		
		Runnable runnable2 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i < 10; i=i+2) {
					System.out.println(i);
					
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		Thread thread1 = new Thread(runnable2);
		thread1.start();
		}
}
