package practise;
import java.util.ArrayDeque;
public class Myarraydequeue {
	public void palindromecheck(String string) {
		boolean result=true;
		ArrayDeque<Character> arrayDeque=new ArrayDeque<Character>();
		char[] c=string.toCharArray();
		for (char d : c) {
			arrayDeque.add(d);
		}
		while (!arrayDeque.isEmpty()) {
			Character firstCharacter=arrayDeque.pollFirst();
			Character lastCharacter=arrayDeque.pollLast();
			
				if (firstCharacter!=lastCharacter) {
					result=false;
					break;
				}	
				else {
					continue;
				}
				
		}
		System.out.println("result "+result);
	}
	
	public static void main(String[] args) {
		Myarraydequeue myarraydequeue=new Myarraydequeue();
		myarraydequeue.palindromecheck("abcba");
	}
}
