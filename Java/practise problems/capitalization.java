/*Java Program to Capitalize the First Letter of Each Word in a String

In Java Programming, we can be able to capitalize the first letter of each word in the given String value by using toUpperCase(), toLowerCase(), and another one is substring() method. These methods are available String class in Java and these methods are useful for our problem. 



Below is the implementation of split() and substring() methods to capitalize the first letter of each word in a String.


*/


package practise_set;

public class Capitalize1 {
	
	public void capitalizaChar(String string)
	{
		String[] resultStrings =string.split("\\s");
		
		StringBuffer stringBuffer =new StringBuffer();
		
		 for (String xString : resultStrings)
		 {
			 stringBuffer.append(Character.toUpperCase(xString.charAt(0)))
			 .append(xString.substring(1,xString.length()))
			 .append(" ");
		 }
		 String afterString=stringBuffer.toString();
		 
		 System.out.println(afterString);
	}
	

	public static void main(String[] args) {
		Capitalize1 capitalize1 = new Capitalize1();
		
		capitalize1.capitalizaChar("hello world");
	}

}


/*

Explanation of the Program:

    In the above program, we have taken one input string value that is welcome to geeksforgeeks.
    After this we split this String into String array by using split() method.
    After that we have taken each character from word by using loop from string array.
    Then change that character from small to capital.
    Then Append the Result to String builder after that it will print the result.

*/