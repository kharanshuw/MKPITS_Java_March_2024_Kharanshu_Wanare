package onlineShoppingPlatform;

public class Book {
Product product=new Product() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("book details");
		}
		
		@Override
		public void calculatePrice() {
			// TODO Auto-generated method stub
			System.out.println("book price");
		}
	};
	public void display() {
		product.calculatePrice();
	product.displayDetails();
	}
}

