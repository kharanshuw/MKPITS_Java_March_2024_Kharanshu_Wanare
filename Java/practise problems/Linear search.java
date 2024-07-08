package methods;

public class MyLiniarsearch {
	public void mysearch(int arr[],int no) {
		int position=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==no) {
				position=i;
				break;
			}
		}
		System.out.println("position of no is"+position);
	}
}

import java.util.Scanner;

import javax.xml.crypto.Data;

import methods.*;

public class Main {
	public static void main(String[] args)
	{
		MyLiniarsearch myLiniarsearch=new MyLiniarsearch();
		int arr[]= {90,75,80,40,60,5,10};
		myLiniarsearch.mysearch(arr, 60);
	}
}
