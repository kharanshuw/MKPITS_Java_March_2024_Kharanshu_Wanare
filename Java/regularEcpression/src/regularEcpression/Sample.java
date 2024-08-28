package regularEcpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample {
public static void main(String[] args) {
	
	//first way
	boolean result=Pattern.matches("hello", "hello");
	
	System.out.println(result);
	
	//second way
	
	Pattern pattern=Pattern.compile(".hello");
	Matcher matcher=pattern.matcher("hello word");
	
	boolean x=matcher.find();
	System.out.println(x);
	
	System.out.println(Pattern.matches("[abc]", "c"));
	
	System.out.println(Pattern.matches("[a-z A-Z]", "aA"));
	
	System.out.println(Pattern.matches("[a-z A-Z]", "aA"));
	
	System.out.println(Pattern.matches("[^a-z A-Z]", "A"));
	
	System.out.println(Pattern.matches("[a-f[m-z]]", "mn"));
	
	System.out.println(Pattern.matches("[a-f] [m-z]", "a n"));
	
	System.out.println(Pattern.matches("[a-f && [^b-c]]", "c"));
	
	System.out.println(Pattern.matches("[a-f] [m-z]", "a n"));
	
	System.out.println(Pattern.matches("[a-z && [^mz]]", "m"));
	
	System.out.println(Pattern.matches("[x?]", "xx"));
	
	System.out.println(Pattern.matches("[a-z]+", "abcdef"));
	
	System.out.println(Pattern.matches("[a-z]*", ""));
	
	System.out.println(Pattern.matches("[a-z]{5}", "abcdfs"));
	
	System.out.println(Pattern.matches("[a-z]{5,}", "abcdfsddg"));
	
	System.out.println(Pattern.matches("[a-z]{5,8}", "abcdfsvm"));
}
}
