package practise;



public class Assign_2 {
	
	public void maximum(int arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			int index=i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[index]>arr[j]) {
					index=j;
				}
			}
			int temp=arr[index];
			arr[index]=arr[i];
			arr[i]=temp;
		}
		
		System.out.println("largest element is"+arr[arr.length-1]);
		System.out.println("smallest element is"+arr[0]);
	}
	
	public static void main(String[] args) {
		Assign_2 assign_2=new Assign_2();
		int arr[]= {10,90,76,81,5,46,99};
		assign_2.maximum(arr);
}
}
