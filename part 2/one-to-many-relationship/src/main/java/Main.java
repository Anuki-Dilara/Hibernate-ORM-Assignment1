import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setAuthorId("A1");
        author.setName("ms.lila");

        Book book = new Book();
        book.setISBN(1);
        book.setName("madolduwa");
        book.setAuthor(author);

        Book book1 = new Book();
        book1.setISBN(2);
        book1.setName("hathpana");
        book1.setAuthor(author);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(author);
        session.persist(book);
        session.persist(book1);
        transaction.commit();
        session.close();
    }
}
