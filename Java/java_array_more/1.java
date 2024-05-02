public class ArrayOperation {
	
	
	
	public void maxDiff(int arr[]) {
		int result=arr[1]-arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				result=Math.max(result, arr[j]-arr[i]);
				
			}
			
		}
		System.out.println(result);
		//time complexity is bigo square
	}
	
}