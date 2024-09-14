package lecture2.homework2.bookcollection;

import java.util.HashSet;
import java.util.Set;

public class BookCollection {

    private final Set<Book> bookCollection = new HashSet<>();

    public void addBook(Book book) {
        bookCollection.add(book);
    }

    public void removeBook(Book book) {
        bookCollection.remove(book);
    }

    public boolean isContainsBook(Book book) {
        return bookCollection.contains(book);
    }

    public void printBooks() {
        for (Book book : bookCollection) {
            System.out.println(book);
        }
    }
}