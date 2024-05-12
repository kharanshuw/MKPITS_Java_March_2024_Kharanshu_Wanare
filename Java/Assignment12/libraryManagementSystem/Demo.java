public class Demo {
public static void main(String[] args) {
	LibraryItem journals = new LibraryItem() {
		
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
	
	LibraryItem dvd = new LibraryItem() {
		
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
	
	LibraryItem books = new LibraryItem() {
		
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
}
}