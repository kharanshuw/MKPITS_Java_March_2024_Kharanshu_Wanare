package syncronizationexample;

public class HotelBooking extends Thread {
	public static double income=0;
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		income=income+1000;
		System.out.println("room booked"+currentThread().getName());
		System.out.println("total earning"+income);
		
		synchronized (this) {
			this.notify();
		}
	}
	
}
