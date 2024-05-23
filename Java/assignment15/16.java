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
	    colors2.add("Reddd");
	    colors2.add("Greeddn");
	    colors2.add("Blueddd");
	    colors2.add("Yelloddw");
	    
	   Collections.copy(colors, colors2);
	   System.err.println(colors);
	    
}
}
