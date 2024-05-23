package assignment14;

public class Main {
	public static void main(String[] args) {
		UniqueEmailCollector uniqueEmailCollector=new UniqueEmailCollector();
		uniqueEmailCollector.add(new Product("1"));
		uniqueEmailCollector.add(new Product("2"));
		uniqueEmailCollector.add(new Product("3"));
		uniqueEmailCollector.add(new Product("4"));
		uniqueEmailCollector.display();
		uniqueEmailCollector.search("1");
		uniqueEmailCollector.remove("2");
		uniqueEmailCollector.display();
	}
}
