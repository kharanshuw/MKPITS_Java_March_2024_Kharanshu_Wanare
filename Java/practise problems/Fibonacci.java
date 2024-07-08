package methods;

import java.util.Iterator;
import java.util.Scanner;

public class Fibonacci {
	public void find() {
		Scanner scanner=new Scanner(System.in);
		int no;
		System.out.println("enter no");
		no=scanner.nextInt();
		int a=0,b=1;
		for (int i = 0; i < no; i++) {
			System.out.println(a+" ");
			int temp=a+b;
			a=b;
			b=temp;	
		}
	}
}
