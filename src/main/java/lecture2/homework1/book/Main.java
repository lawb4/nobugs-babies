package lecture2.homework1.book;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();
        book.setName("Над пропастью во ржи");
        book.setAuthor("Джером Сэлинджер");
        book.setYearPublished(1951);

        book.display();
    }
}
