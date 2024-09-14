package lecture2.homework2.bookcollection;

import java.util.Objects;

public class Book {

    private final String title;
    private final String author;

    public Book(String name, String author) {
        this.title = name;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("Книга \"%s\" автора %s;", getTitle(), getAuthor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
