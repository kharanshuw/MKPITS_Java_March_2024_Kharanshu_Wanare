public class MyBinarySearch {
	public void MySearch(int arr[],int no) {
		int mid;
		int start;
		int end;
		start=0;
		end=arr.length-1;
		
		while (end>=start) {
			mid=start+end;
			if (arr[mid]==no) {
				System.out.println("position of element is"+mid);
				return;
			}
			else if (arr[mid]>no) {
				end=mid-1;
			}
			else if (arr[mid]<no) {
				start=mid+1;
			}
			
		}
		
			System.out.println("no no present");
	}
}
