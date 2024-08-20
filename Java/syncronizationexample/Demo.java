package syncronizationexample;

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
