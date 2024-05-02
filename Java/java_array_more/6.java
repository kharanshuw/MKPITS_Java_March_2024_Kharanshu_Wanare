public class ArrayOperation {
	
	public void frequency(int arr[],int no) {
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==no) {
				count++;
			}
		}
		System.out.println(count);
	}
	
}