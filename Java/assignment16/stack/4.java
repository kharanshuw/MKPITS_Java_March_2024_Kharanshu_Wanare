package practise;

import java.util.Stack;

public class Assignment {
	final char leftpara='(';
	final char rightpara=')';
	final char add='+';
	final char sub='-';
	final char mul='*';
	final char div='/';
	
	public int precedence(char operator) {
		switch (operator) {
		case add: {
			return 1;
		}
		case sub:
		{
			return 1;			
		}
		case mul:
		{
			return 2;
			
		}
		case div:
		{
			return 2;
			
		}
		default:
			return -1;
		}
	}
	
	public void infixToPostfix(String infixString ) {
		StringBuilder stringBuilder=new StringBuilder();
		Stack<Character> stack=new Stack<Character>();
		for (Character ch : infixString.toCharArray()) {
			if (Character.isDigit(ch)) {
				stringBuilder.append(ch);
			}
			else if (leftpara==ch) {
				stack.push(ch);
			}
			else if (rightpara==ch) {
				
				 if (stack.isEmpty()) { // this line is still giving exception 
		                throw new RuntimeException("Mismatched parentheses in infix expression");
		            }
				while (!stack.isEmpty() && stack.peek()!=leftpara) {
					char x=stack.pop();
					stringBuilder.append(x);
				}
					stack.pop();
				
			}
			else {
				while (!stack.isEmpty() && precedence(stack.peek())>=precedence(ch)) {
					char x=stack.pop();
					stringBuilder.append(x);
				}
				stack.push(ch);
			}
			while (!stack.isEmpty()) {
				stringBuilder.append(stack.pop());
			}
			
		}
		System.out.println("postfix expression is "+stringBuilder);
	}
	
	public static void main(String[] args) {
		Assignment assignment=new Assignment();
	        assignment.infixToPostfix("a+b*(c-d)");
	        
	}
}
