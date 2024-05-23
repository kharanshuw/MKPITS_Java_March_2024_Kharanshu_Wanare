import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Myarraylist {
	public static void main(String[] args) {
	    ArrayList<String> colors = new ArrayList<String>();
	    colors.add("Red");
	    colors.add("Green");
	    colors.add("Blue");
	    colors.add("Yellow");

	    System.out.println( colors);

	    Collections.shuffle(colors);

	    System.out.println(colors);
	  }
}
