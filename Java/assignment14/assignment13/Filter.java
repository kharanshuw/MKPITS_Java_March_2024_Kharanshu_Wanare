package assignment14.assignment13;

import java.util.HashSet;
public class Filter {
	public static void main(String[] args) {
		HashSet<Character> hashSet=new HashSet<Character>();
		hashSet.add('a');
		hashSet.add('b');
		hashSet.add('a');
		hashSet.add('d');
		hashSet.add('e');
		System.out.println(hashSet);
		System.out.println( hashSet.contains('d'));
		System.out.println(hashSet.remove('d'));
	}
}
