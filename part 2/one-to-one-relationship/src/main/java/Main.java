import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Book book=new Book();
        book.setISBN(1);
        book.setName("madolduwa");

        Author author=new Author();
        author.setAuthorId("A1");
        author.setName("ms.lila");

        author.setbook(book);
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.persist(book);
        session.persist(author);

        transaction.commit();
        session.close();
    }
}
