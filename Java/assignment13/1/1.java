package syncronizationexample;

public class HotelBooking extends Thread {
	public static double income=0;
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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

public class Demo extends Object {
	public static void main(String[] args) {
		int room=10;
		for (int i = 0; i < 11; i++) {
			
			HotelBooking hotelBooking = new HotelBooking();
			hotelBooking.start();			
			synchronized (hotelBooking) {
				try {
					hotelBooking.wait();
				} catch (InterruptedException e) {
					System.out.println("exception occured");
					e.printStackTrace();
				}
			}
		}
	}
}
