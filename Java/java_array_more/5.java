public class ArrayManipulation {
	
	public void rotateArrayright(int arr[],int k) {
		reverse(arr, 0, arr.length-1);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		reverse(arr, 0,k-1 );
		reverse(arr, k, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void rotatearrayleft(int arr[],int k) {
		reverse(arr, 0, arr.length-1);
		reverse(arr,arr.length-1,arr.length-1-k);
		reverse(arr, 0,arr.length-1-k);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public int[] reverse(int arr[],int start,int end) {
		while (start<end) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
		return arr;
	}
}
