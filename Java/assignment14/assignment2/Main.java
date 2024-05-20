package inventoryManagementSystem;

public class Main {
public static void main(String[] args) {
	InventoryManagementSystem inventoryManagementSystem=new InventoryManagementSystem();
	inventoryManagementSystem.addNewProduct(1, "cake", 5, 200);
	inventoryManagementSystem.addNewProduct(2, "cake", 5, 250);
	inventoryManagementSystem.addNewProduct(3, "cake", 5, 300);
	inventoryManagementSystem.display();
	inventoryManagementSystem.removeProduct(1);
	System.out.println("product details");
	inventoryManagementSystem.display();
}
}
