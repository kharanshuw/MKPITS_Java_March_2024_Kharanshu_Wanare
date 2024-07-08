//program to find the count of given substring




public class SplitTest {
	String nameString="I expect that the level of abstraction of our languages will continue to increase. I also expect that the number of domain-specific languages will continue to grow. Thiswill be a good thing. But it will not eliminate code. Indeed, all the specifications written in these higher level and domain-specific language will be code! It will still need to	be rigorous, accurate, and so formal and detailed that a machine can understand and execute it.";
	String regexString="[\\s]";
	String[] arr1=nameString.split(regexString);
	public void printarr() {
		for (int i = 0; i < arr1.length; i++) {
			String string = arr1[i];
			System.out.println(string);
		}
	}
	
	public void checkstring(String x) {
		int count=0;
		for (int i = 0; i < arr1.length; i++) {
			String checkString=arr1[i];
			int result=x.compareTo(checkString);
			if (result==0) {
				count=count+1;
			}
		}
		System.out.println(count-1);
	}
}
