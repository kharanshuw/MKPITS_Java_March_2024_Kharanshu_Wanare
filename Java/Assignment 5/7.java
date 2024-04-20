package practise;

public class FindDuplicates {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 2, 6, 7, 8, 9, 5 };
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {

					System.out.println("Duplicate element: " + array[j]);
				}
			}
		}
	}
}
