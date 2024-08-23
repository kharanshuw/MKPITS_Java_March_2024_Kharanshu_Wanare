package threads;
//this is example of inner class which are implementing runnable and creating thread
public class Myouterclass {

	public class Mythred1 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub;
			for (int i = 0; i < 10; i=i+2) {
				System.out.println(i);
				
			}
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
		
	}
	
	public class Mythred2 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 1; i < 10; i=i+2) {
				System.out.println(i);
			}
		}
		
	}
	
	public void display() {
		Mythred1 mythred1=new Mythred1();
		Thread thread = new Thread(mythred1);
		Mythred2 mythred2= new Mythred2();
		Thread thread2 = new Thread(mythred2);
		
		thread.start();
		thread2.start();
		
	}
}
