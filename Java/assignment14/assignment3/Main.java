package assignment14.assignment3;

public class Main {
	public static void main(String[] args) {
		Book book =new Book("1", "a", "a",1999);
		Book book2 =new Book("1", "a", "a",2000);
		Book book3 =new Book("1", "a", "a",2001);
		Book book4 =new Book("1", "a", "a",2002);
		Library library=new Library();
		library.addBook(book4);
		library.addBook(book3);
		library.addBook(book2);
		library.addBook(book);
		library.displaysortedorder();
		library.display(1999);
		
	}
}
