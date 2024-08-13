package matrix;

import java.util.Iterator;

public class Matrix {
	public void sumofrows(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			int sum=0;
			for (int j = 0; j < arr.length; j++) {
				sum=sum+arr[i][j];
			}
			System.out.println(sum);
		}
	}
	
	public void sumofcolums(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			int sum=0;
			for (int j = 0; j < arr.length; j++) {
				sum=sum+arr[j][i];
			}
			System.out.println(sum);
		}
	}
	public void productofrows(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			int product=1;
			for (int j = 0; j < arr.length; j++) {
				product=product*arr[i][j];
			}
			System.out.println(product);
		}
	}
	public void productofcolums(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			int product=1;
			for (int j = 0; j < arr.length; j++) {
				product=product*arr[j][i];
			}
			System.out.println(product);
		}
	}
	
	public void Transpose(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println("");
		}
	}	
	
	public void sparcematrix(int arr[][]) {
		int count=0;
		int avg=(arr.length*arr[0].length)/2;
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j]==0) {
					count++;
				}
			}
		}
		if (count>avg) {
			System.out.println("this is sparce matrix");
		}
		else {
			System.out.println("this is non sparce matrix");
		}
	}
}
