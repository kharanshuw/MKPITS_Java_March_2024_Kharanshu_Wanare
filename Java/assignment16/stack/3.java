package practise;

import java.util.Iterator;
import java.util.Stack;

public class Mystack {
	
	public void reverseString(String string) {
		Stack<Character> stack=new Stack<Character>();
		for (char string2 : string.toCharArray()) {
			stack.push(string2);
		}
		while (stack.isEmpty()==false) {
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		Mystack mystack=new Mystack();
		mystack.reverseString("Hello, world!");
	}

}
