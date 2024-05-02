public class ArrayOperation {
	
	public void evenElementsatEvenIndex(int arr[]) {
		for (int i = 0; i < arr.length; i=i+2) {
			if (arr[i]%2 == 0) {
				System.out.println(arr[i]);
			}
		}
	}
}