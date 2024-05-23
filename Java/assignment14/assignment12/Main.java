package assignment14.assignment12;

public class Main {
public static void main(String[] args) {
	Product product=new Product("a");
	Product product2=new Product("b");
	Product product3= new Product("c");
	Product product4=new Product("d");
	Product product5=new Product("d");
	ProductIdentifierManager productIdentifierManager=new ProductIdentifierManager();
	productIdentifierManager.add(product4);
	productIdentifierManager.add(product3);
	productIdentifierManager.add(product2);
	productIdentifierManager.add(product);
	productIdentifierManager.add(product5);
	
	productIdentifierManager.display();
	productIdentifierManager.remove("c");
	productIdentifierManager.check("c");
}
}
