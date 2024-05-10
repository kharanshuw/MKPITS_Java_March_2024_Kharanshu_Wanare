package libraryManagementSystem;

public class Journals {
LibraryItem libraryItem = new LibraryItem() {
		
		@Override
		public void returnItem() {
			// TODO Auto-generated method stub
			System.out.println("return journals ");
			
		}
		
		@Override
		public void checkOut() {
			// TODO Auto-generated method stub
			System.out.println("checkout journals");
		}
	};
	
	public void display() {
		libraryItem.checkOut();
		libraryItem.checkOut();
	}
}
