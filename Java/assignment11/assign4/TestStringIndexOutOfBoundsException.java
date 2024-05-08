package assignment11.assign4;

public class TestStringIndexOutOfBoundsException {

	public void testException(String string) {
		for (int i = 0; i <= string.length(); i++) {
			System.out.println(string.charAt(i));
		}
	}
}
