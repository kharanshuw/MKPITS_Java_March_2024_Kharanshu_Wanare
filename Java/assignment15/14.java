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

	   System.out.println(colors);
	   
	   Collections.swap(colors,1,2);
}
}
