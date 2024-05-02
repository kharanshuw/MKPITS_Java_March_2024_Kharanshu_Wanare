public class ArrayOperation {
	
	public void removeElement(int arr[],int no) {
		int arr1[]=new int[arr.length-1];
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]!=no) {
				arr1[j]=arr[i];
				j++;
			}
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);			
		}
}