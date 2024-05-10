package libraryManagementSystem;

public class Books {
	LibraryItem libraryItem = new LibraryItem() {
		
		@Override
		public void returnItem() {
			// TODO Auto-generated method stub
			System.out.println("return book ");
			
		}
		
		@Override
		public void checkOut() {
			// TODO Auto-generated method stub
			System.out.println("checkout book");
		}
	};
	
	public void display() {
		libraryItem.checkOut();
		libraryItem.returnItem();
	}
}
