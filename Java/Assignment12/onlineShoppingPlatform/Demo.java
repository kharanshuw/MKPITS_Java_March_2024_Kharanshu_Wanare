public class Demo {
public static void main(String[] args) {
Product electronic=new Product() {
		
		@Override
		public void displayDetails() {
			// TODO Auto-generated method stub
			System.out.println("electronic details");
		}
		
		@Override
		public void calculatePrice() {
			// TODO Auto-generated method stub
			System.out.println("electronic price");
		}
	};
	
	Product cloth=new Product() {
		
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
	
	Product book=new Product() {
		
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
	
	
}
}