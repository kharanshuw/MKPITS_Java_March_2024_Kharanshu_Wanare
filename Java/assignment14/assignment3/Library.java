package assignment14.assignment3;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
class Library {
    List<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void removeBookByISBN(String ISBN) {
    Iterator<Book> iterator = books.iterator();
    while (iterator.hasNext()) {
        Book book = iterator.next();
        if (book.ISBN.equals(ISBN)) {
            iterator.remove();
            break;
        }
    }
}


    Book searchBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.ISBN.equals(ISBN)) {
                return book;
            }
        }
        return null;
    }
    
    public void display(int year) {
		ListIterator<Book> bkIterator=books.listIterator();
		while (bkIterator.hasNext()) {
			Book book = (Book) bkIterator.next();
			if (book.yearPublished>year) {
				System.out.println("book details"+book);
			}
		}
	}
    
    public void displaysortedorder() {
		Collections.sort(books);
		ListIterator<Book> bkIterator=books.listIterator();
		while (bkIterator.hasNext()) {
			Book book = (Book) bkIterator.next();
			
				System.out.println("book details"+book);
			
		}
	}
    
    
   
}
