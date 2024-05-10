package onlineShoppingPlatform;

public class Electronics {
	Product product=new Product() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("product details");
		}
		
		@Override
		public void calculatePrice() {
			// TODO Auto-generated method stub
			System.out.println("electronic price");
		}
	};
	public void display() {
		product.calculatePrice();
	product.displayDetails();
	}
}
