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
	    
	    colors.set(1, "black");
	    System.out.println(colors);
	    
}
}
