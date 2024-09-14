package lecture2.homework2.bookcollection;

public class Main {
    public static void main(String[] args) {

        BookCollection bookCollection = new BookCollection();
        Book book1 = new Book("Над пропастью во ржи", "Джером Сэлинджер");
        Book book2 = new Book("Atomic Habits", "James Clear");
        Book duplicateBook2 = new Book("Atomic Habits", "James Clear");

        System.out.println("~Добавили 2 разные книги.");
        bookCollection.addBook(book1);
        bookCollection.addBook(book2);

        System.out.println("~Теперь книжная коллекция состоит из двух уникальных книг. Перечислим их:");
        bookCollection.printBooks();

        System.out.println("~Попытка добавить в книжную коллекцию дубликат существующей книги.");
        bookCollection.addBook(duplicateBook2);

        System.out.println("~Попытка добавить ещё одну существующую книгу не удалась. Книжная коллекция всё равно состоит из двух уникальных книг:");
        bookCollection.printBooks();

        System.out.println("~Проверяем, что дубликат книги, которую мы хотели добавить, действительно является дубликатом, а не новой книгой");

        if (bookCollection.isContainsBook(duplicateBook2)) {
            System.out.println(">>> Данная книга действительно уже находится в книжной коллекции.");
        } else {
            System.out.println(">>> Странно. Кажется, данной книги не было в коллекции.");
        }

        System.out.println("~Так как книга-дубликат, которую мы пытались добавить, полностью равнозначна уже существующей в коллекции книге, то если мы попробуем удалить книгу-дубликат, уже существующая в коллекции книга тоже удалится. Это особенности переопределенных методов HashCode() и Equals() в классе Books.");
        System.out.println("~Удаляем книгу-дубликат и смотрим, какие книги остались в коллекции. Должна остаться только одна книга:");
        bookCollection.removeBook(duplicateBook2);
        bookCollection.printBooks();
    }
}
