
public class Myarraylist {
public static void main(String[] args) {
	   ArrayList<String> colors = new ArrayList<String>();
	    colors.add("Red");
	    colors.add("Green");
	    colors.add("Blue");
	    colors.add("Yellow");

	   System.out.println(colors);
	   
	   List<String> arrayList=(List<String>) colors.subList(0, 2);
	   System.out.println(arrayList);
	  }
}

