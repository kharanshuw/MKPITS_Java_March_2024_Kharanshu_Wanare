package taxSystem;

import java.util.Scanner;

public class CalculateTotalTax {
//	public void totaltax() {
//		Maharashtra maharashtra = new Maharashtra();
//		double result = 0;
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("enter amount");
//		double amount = scanner.nextDouble();
//		double tax1 = maharashtra.getCentraltax(amount);
//		double tax2 = maharashtra.taxCalculate(amount);
//		result = tax1 + tax2;
//		System.out.println(result);
//
//	}
	
	public void totaltax2(StateTax stateTax) {
		double tax1=stateTax.taxCalculate(500);
		double tax2=new CentralTax().getCentraltax(500);
		double result=tax1+tax2;
		System.out.println(result);
	}
}
