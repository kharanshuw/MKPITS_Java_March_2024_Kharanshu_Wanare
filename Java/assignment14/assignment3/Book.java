import java.util.ArrayList;
import java.util.List;

class Book {
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
}

