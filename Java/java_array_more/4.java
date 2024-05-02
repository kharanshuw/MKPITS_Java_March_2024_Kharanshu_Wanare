public class ArrayOperation {
	
	
	public void evenoddSepration(int arr[]) {
		int[] arr1=new int[arr.length-1];
		int[] arr2=new int[arr.length-1];
		int j=0;
		int k=0;
 		for (int i = 0; i < arr.length; i++) {
			if (arr[i]%2==0) {
				arr1[j]=arr[i];
				j++;
			}
			else if (arr[i]%2!=0) {
				arr2[k]=arr[i];
				k++;
			}
		}
 		System.out.println("even no's");
 		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
 		
 		System.out.println("odd no's");
 		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}
