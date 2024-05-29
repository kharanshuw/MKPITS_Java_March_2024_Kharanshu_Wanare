package practise;

import java.util.Stack;

public class PostfixEvaluation {
	public int evaluation(String s) {
		Stack<Integer> stack=new Stack<Integer>();
		int x=0;
		int y=0;
		char[] ch=s.toCharArray();
		for (char c : ch) {
			
			if (c>='0' && c<='9') {
				stack.push((int)(c-'0'));
			}
			else {
				
				
				y=stack.pop();
				x=stack.pop();
				switch (c) {
				case '+': {
					stack.push(x+y);
					break;
				}
				case '-':{
					stack.push(x-y);
					break;
				}
				case '*':{
					stack.push(x*y);
					break;
				}
				case '/':{
					stack.push(x/y);
					break;
				}
				
			}
		}
	}
	return stack.pop();
}
	public static void main(String[] args) {
		PostfixEvaluation postfixEvaluation=new PostfixEvaluation();
		int resultInteger=postfixEvaluation.evaluation("23+4*");
		System.out.println(resultInteger);
	}
}
