
import java.util.ArrayList;
import java.util.Collections;

public class Myarraylist {
public static void main(String[] args) {
	   ArrayList<String> colors = new ArrayList<String>();
	    colors.add("Red");
	    colors.add("Green");
	    colors.add("Blue");
	    colors.add("Yellow");

	    System.out.println( colors);

	    Collections.reverse(colors);

	    System.out.println(colors);
	  }
}

