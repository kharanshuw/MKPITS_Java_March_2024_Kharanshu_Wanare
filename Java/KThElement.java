package practise;

import java.util.Iterator;

public class KThElement {

	public static void main(String[] args) {
		int arr1[]= {90,45,60,70,82,94,4,88,79};
		int item=0;
		int k=4;
		for (int i = 0; i < arr1.length-1; i++) {
			int index=i;
			for (int j = i+1; j < arr1.length; j++) {
				if (arr1[index]<arr1[j]) {
					index=j;
				}
			}
			int smallest=arr1[index];
			arr1[index]=arr1[i];
			arr1[i]=smallest;
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("k th biggest element is "+arr1[k-1]	);
		item=arr1.length-k;
		System.out.println("k th smallest element is "+arr1[item]);
		}

}
