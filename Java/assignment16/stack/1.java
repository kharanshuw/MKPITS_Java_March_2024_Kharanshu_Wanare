package practise;

import java.util.Stack;
public class ParenthesisChecker {

    public boolean isParenthesisMatching(String string) {
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i < string.length(); i++) {
            char c=string.charAt(i);
            if (isopening(c)==true) {
                stack.push(c);
            }
            else if (isclosing(c)) {
            	if (stack.isEmpty() || !ismatching(stack.pop(), c)) {
                    return false;
                }
			} 
        }
        return stack.isEmpty();
    }

    public boolean isopening( char c) {
    	return c == '(' || c == '{' || c == '[';
    }
    
    public boolean isclosing(char c) {
    	return c == ')' || c == '}' || c == ']';
		
		}
    
    public boolean ismatching(char a,char b) {
		if (a=='(' && b==')') {
			return true;
		}
		else if (a=='{' && b=='}') {
			return true;
		}
		else if (a=='[' && b==']') {
			return true;
		}
		else {
			return false;
		}
	}

    public static void main(String[] args) {
    	ParenthesisChecker parenthesisChecker =new ParenthesisChecker();
    	boolean result=parenthesisChecker.isParenthesisMatching("([{}])");
    	System.out.println(result);
    }
}