package onlineShoppingPlatform;

public class Clothing {
Product product=new Product() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("cloth details");
		}
		
		@Override
		public void calculatePrice() {
			// TODO Auto-generated method stub
			System.out.println("cloth price");
		}
	};
	public void display() {
		product.calculatePrice();
	product.displayDetails();
	}
}
