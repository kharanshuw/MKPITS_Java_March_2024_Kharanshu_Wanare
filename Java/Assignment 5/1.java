package myproject;

import java.security.PublicKey;

public class PeakElement {
	public void peakElementFind(int arr[]) {
		int peak=arr[0];
		if (arr[1]<arr[0]) {
			peak=arr[1];
			System.out.println("peak element is "+peak);
			return;
		}
		else {
			for (int i = 1; i < arr.length-1; i++) {
				if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
				{
					peak=arr[i];
					System.out.println("peak element is "+peak);
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		PeakElement peakElement = new PeakElement();
		int arr[]= {10,20,30,40,50,50,60,70,80};
		peakElement.peakElementFind(arr);
	}
}
