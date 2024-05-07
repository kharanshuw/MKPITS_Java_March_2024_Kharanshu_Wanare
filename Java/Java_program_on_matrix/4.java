package matrix;

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
}
