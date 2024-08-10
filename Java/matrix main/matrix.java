package main;

import matrix.Matrix;

public class Main {

	public static void main(String[] args) {
		Matrix matrix=new Matrix();
		 int a[][] = {       
				 {1,3,4},
				 {2,4,3},
				 {3,4,5}
             };    
		matrix.sparcematrix(a);
	}

}
