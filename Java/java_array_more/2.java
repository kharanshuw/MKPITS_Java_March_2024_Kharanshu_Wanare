package myProject;

import java.util.Arrays;

public class ArrayOperation {
	
	
	public void insertElement(int no,int position,int arr[]) {
		Arrays.fill(arr,position-1,position,no);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}