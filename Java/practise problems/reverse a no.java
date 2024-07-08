package practice;

public class NumberManipulation {
	
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
		numberManipulation.revNumber(8999);
	}

}
