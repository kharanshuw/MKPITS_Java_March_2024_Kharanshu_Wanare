package assignment14.assignment3;

import java.util.ArrayList;
import java.util.List;

class Book implements Comparable<Book>{
    String ISBN;
    String title;
    String author;
    int yearPublished;

    Book(String ISBN, String title, String author, int yearPublished) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Title: " + title + ", Author: " + author + ", Year Published: " + yearPublished;
    }

	@Override
	public int compareTo(Book o) {
		if (o.yearPublished==this.yearPublished) {
			return 0;
		}
		else if (o.yearPublished<this.yearPublished) {
			return 1;
		}
		else {
			return -1;
		}
	}
}

