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

   prublic List<Book> getBooksPublishedAfter(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.yearPublished > year) {
                result.add(book);
            }
        }
        return result;
    }
}
