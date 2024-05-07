

class Matrix{
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
