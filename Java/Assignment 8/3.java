package methods;

public class Factorial {
	public void find(int no) {
		int sum=1;
		while (no>0) {
			sum=sum*no;
			no--;
		}
		System.out.println("factorial is "+sum);
	}
}
