package assignment14.assignment10;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class HistoryTracking {
	LinkedList linkedList=new LinkedList<WebPage>();
	
	public void add(WebPage webPage) {
		linkedList.add(webPage);
	}
	public void remove(String pageId) {
		Iterator<WebPage> iterator=linkedList.iterator();
		while (iterator.hasNext()) {
			WebPage webPage = (WebPage) iterator.next();
			if (pageId.equals(webPage.getPageId())) {
				iterator.remove();
				
			}
		}
	}
	
	public void details(String url) {
		Iterator<WebPage> iterator=linkedList.iterator();
		while (iterator.hasNext()) {
			WebPage webPage = (WebPage) iterator.next();
			if (url.equals(webPage.getUrl())) {
				System.out.println(webPage);
				
			}
		}
	}
	
	public void display() {
		Iterator<WebPage> iterator=linkedList.iterator();
		while (iterator.hasNext()) {
			WebPage webPage = (WebPage) iterator.next();
			
				System.out.println(webPage);
				
		
		}
	}
	
	public void sort() {
		Collections.sort(linkedList,new DateComprator());
	}
}
