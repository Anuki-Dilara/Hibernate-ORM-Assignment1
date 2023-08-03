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

        Author author2 = new Author();
        author2.setAuthorId("A2");
        author2.setName("ms.lilawathi");

        Book book = new Book();
        book.setISBN(1);
        book.setName("madolduwa");

        Book book1 = new Book();
        book1.setISBN(2);
        book1.setName("hathpana");

        List<Author> authorList = new ArrayList<>();
        authorList.add(author);
        authorList.add(author2);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        author.setBookList(bookList);
        author2.setBookList(bookList);

        book.setAuthorList(authorList);
        book1.setAuthorList(authorList);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(author);
        session.persist(author2);
        session.persist(book);
        session.persist(book1);

        transaction.commit();
        session.close();
    }
}
