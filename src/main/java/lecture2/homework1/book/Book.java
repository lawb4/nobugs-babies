package lecture2.homework1.book;

public class Book implements Displayable {

    private String title;
    private String author;
    private int yearPublished;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public void display() {
        System.out.printf("Книга \"%s\" автора %s была издана в %d году",
                getTitle(), getAuthor(), getYearPublished());
    }
}
