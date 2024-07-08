package methods;

import java.util.Iterator;

public class MySelectionSort {
	public void mysort(int arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			int index=i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[index]>arr[j]) {
					index=j;
				}
			}
			int temp=arr[index];
			arr[index]=arr[i];
			arr[i]=temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
