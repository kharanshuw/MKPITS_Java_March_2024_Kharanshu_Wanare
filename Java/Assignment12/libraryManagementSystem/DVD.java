package libraryManagementSystem;

public class DVD {
	LibraryItem libraryItem = new LibraryItem() {
		
		@Override
		public void returnItem() {
			// TODO Auto-generated method stub
			System.out.println("return dvd ");
			
		}
		
		@Override
		public void checkOut() {
			// TODO Auto-generated method stub
			System.out.println("checkout dvd");
		}
	};
	
	public void display() {
		libraryItem.returnItem();
		libraryItem.checkOut();
	}
}
