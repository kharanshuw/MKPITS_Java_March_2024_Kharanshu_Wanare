package practise;

public class FirstRepeatingElement {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 2, 6, 7, 8, 9, 5 };

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					System.out.println("First repeating element: " + array[i]);
					return;
				}
			}
		}
		System.out.println("No repeating element found.");
	}
}
