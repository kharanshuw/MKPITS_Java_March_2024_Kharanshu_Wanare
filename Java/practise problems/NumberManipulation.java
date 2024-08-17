package practice;

public class NumberManipulation {
	
	
	public void perfectno(int no) {
		int sum=0;
		for (int i = 1; i < no; i++) {
			if (no%i==0) {
				sum=sum+i;
			}
		}
		System.out.println(sum);
		if (sum==no) {
			System.out.println("this is perfect no");
		}
		else {
			System.out.println("not perfect no");
		}
	}
	
	public void revNumber(int no) {
		String string = String.valueOf(no);
		System.out.println(string);
		System.out.println(((Object) string).getClass().getSimpleName());
		StringBuilder stringBuilder = new StringBuilder(string);
		stringBuilder.reverse();
		System.out.println(stringBuilder);
		string = stringBuilder.toString();
		int x = Integer.parseInt(string);
		System.out.println(x);
	}

	public static void main(String[] args) {
		NumberManipulation numberManipulation = new NumberManipulation();
		numberManipulation.perfectno(7);
	}

}
