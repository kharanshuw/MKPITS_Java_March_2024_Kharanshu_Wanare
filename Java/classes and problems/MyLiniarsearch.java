package methods;

public class MyLiniarsearch {
	public void mysearch(int arr[],int no) {
		int position=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==no) {
				position=i;
				break;
			}
		}
		System.out.println("position of no is"+position);
	}
}
