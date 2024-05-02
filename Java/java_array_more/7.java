public class ArrayOperation {
	
	public void incrementElement(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i]=arr[i]+1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
 }