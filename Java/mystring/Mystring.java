package mystring;

public class Mystring {
	public static void main(String[] args) {
		String string=new String();
		System.out.println(string);
		char c[]= {'a','b','c','d','e','f'};
		String string2 = new String(c);
		System.out.println(c);
		String string3= new String(c,0,2);
		System.out.println(string3);
		int[] bytes = new int[] { 65, 66, 67, 68 };
	    System.out.println(new String(bytes, 1, 2));
	    String myStr = "Hello";
	    char result = myStr.charAt(0);
	    String string4 = "Hello";
	    int result2 = string4.codePointAt(0);
	    System.out.println(result2);
	    String string5 =new String("abc");
	    string5.concat("def");
	    System.out.println(string5);
	}
}
