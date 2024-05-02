public class ArrayOperation {
	
	public void sortStringArrayAscending(String[] strings) {
		System.out.println("string array before sort");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		Arrays.sort(strings);
		System.out.println("string array after sort");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
}