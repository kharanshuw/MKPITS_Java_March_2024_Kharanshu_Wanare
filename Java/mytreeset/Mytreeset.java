package mytreeset;

import java.util.TreeSet;

public class Mytreeset {
	public static void main(String[] args) {
		TreeSet<Integer> tree=new TreeSet<Integer>();
		
		tree.add(9);
		tree.add(5);
		tree.add(1);
		
		System.out.println(tree);
		
		TreeSet<Integer> treeSet=new TreeSet<Integer>(tree);
		treeSet.add(55);
		treeSet.add(90);
		System.out.println(treeSet);
		Integer i=treeSet.ceiling(40);
		System.out.println(i);
	}
}
