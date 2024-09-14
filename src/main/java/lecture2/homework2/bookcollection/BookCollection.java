package lecture2.homework2.bookcollection;

import java.util.HashSet;
import java.util.Set;

public class BookCollection {

    private final Set<Book> bookSet = new HashSet<>();

    public void addBook(Book book) {
        bookSet.add(book);
    }

    public void removeBook(Book book) {
        bookSet.remove(book);
    }

    public boolean isContainsBook(Book book) {
        return bookSet.contains(book);
    }

    public void printBooks() {
        for (Book book : bookSet) {
            System.out.println(book);
        }
    }
}