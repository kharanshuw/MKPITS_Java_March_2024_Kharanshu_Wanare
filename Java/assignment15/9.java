public class Myarraylist {
	public static void main(String[] args) {
		ArrayList<String> arrayList=new ArrayList<String>();
		
		
		arrayList.add("red");
		arrayList.add("blue");
		arrayList.add("green");
		
		arrayList.add(0, "yello");
		
		arrayList.set(0, "white");
		
		ArrayList<String> arrayList2=new ArrayList<String>();
		Collections.copy(arrayList, arrayList2);
		
		
		
	}
}
