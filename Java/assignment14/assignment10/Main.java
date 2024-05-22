package assignment14.assignment10;

public class Main {
public static void main(String[] args) {
	HistoryTracking historyTracking=new HistoryTracking();
	WebPage webPage=new WebPage("1", "a", "aa", "18");
	WebPage webPage2=new WebPage("2", "b", "bb", "19");
	WebPage webPage3=new WebPage("3", "c", "cc", "21");
	WebPage webPage4=new WebPage("4", "d", "dd", "20");
	
	historyTracking.add(webPage4);
	historyTracking.add(webPage3);
	historyTracking.add(webPage2);
	historyTracking.add(webPage);
	
	historyTracking.display();
	
	historyTracking.sort();
	System.out.println("********************************");
	historyTracking.display();
	System.out.println("********************************");
	historyTracking.details("d");
	System.out.println("********************************");
}
}
