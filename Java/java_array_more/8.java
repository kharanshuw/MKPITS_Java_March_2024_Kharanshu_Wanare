
public class ArrayManipulation {
	public void countNoOfElements(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int a=arr[i];
			int count=0;
			if (a==-1) {
				continue;
			}
			else {
				for (int j = 0; j < arr.length; j++) {
					if (a==arr[j]) {
						count++;
						arr[j]=-1;
					}
				}
			}
			System.out.println("count of "+a+"is "+count);
		}
		
	}
	}