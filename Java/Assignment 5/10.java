package myproject;

import java.util.Iterator;

public class CountOccurrences {
	public void count(int arr[]) {
		int freq[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < freq.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					freq[j] = -1;
				}
			}
			if (freq[i] != -1) {
				freq[i] = count;
			}
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != -1) {
				System.out.println("frequency of " + arr[i] + "is " + freq[i]);
			}
		}
	}
}


package myproject;

public class Main {

	public static void main(String[] args) {
		CountOccurrences countOccurrences=new CountOccurrences();
		int arr[]= {10,20,10,50,4,0,66,40,20,10,50,90,90,90,10};
		
		countOccurrences.count(arr);
		
		
	}

}
