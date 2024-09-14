package lecture2.homework1.book;

public class Book implements Displayable {

    private String name;
    private String author;
    private int yearPublished;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                getName(), getAuthor(), getYearPublished());
    }
}
