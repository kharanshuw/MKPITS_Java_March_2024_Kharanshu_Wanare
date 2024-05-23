
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Myarraylist {
public static void main(String[] args) {
	   ArrayList<String> colors = new ArrayList<String>();
	    colors.add("Red");
	    colors.add("Green");
	    colors.add("Blue");
	    colors.add("Yellow");

	    ArrayList<String> colors2 = new ArrayList<String>();
	    colors2.add("Red");
	    colors2.add("Green");
	    colors2.add("Blue");
	    colors2.add("Yellow");
	    
	    if (colors.equals(colors2)==true) {
			System.out.println("both are equal");
		}
	    else {
			System.out.println("both are difference");
		}
}
}
