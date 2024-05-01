public class SmallestString {
	public void findSmallest(String string1) {
		String [] strings=string1.split(" ");
		int length=	0;
		String smalleString=null;
		String biggeString=null;
		int length1=0;
		for (String string : strings) {
			if (length<string.length()) {
				length=string.length();
				biggeString=string;
			}
			else if (length>string.length()) {
				length1=string.length();
				smalleString=string;
			}
		}
		System.out.println(smalleString);
		System.out.println(biggeString);
	}
}
