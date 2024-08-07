package library_management_system;

import java.nio.channels.NonWritableChannelException;
import java.util.Scanner;

public class Book {
	private String titleString;
	private String authorString;
	private boolean available;
	
	Scanner scanner=new Scanner(System.in);
	
	public Book(String titleString, String authorString, boolean available) {
		super();
		this.titleString = titleString;
		this.authorString = authorString;
		this.available = available;
		
	}

	public String getTitleString() {
		return titleString;
	}

	public String getAuthorString() {
		return authorString;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
