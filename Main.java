import entities.Address;
import entities.Author;
import entities.Book;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;


import javax.persistence.metamodel.EntityType;

import java.util.*;

import static utils.HibernateUtil.getSession;

/**
 * Created by Lenovo-1 on 05-07-2017.
 */
public class Main {
    /*private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }*/

    public static void main(final String[] args) throws Exception {

        final Session session = getSession();
        try {
//          Question 2 :
//          Create and Update
            session.beginTransaction();
            Author author=new Author();
            author.setAge(32);
            author.setId(1);
            author.setFirstname("Ram");
            author.setLastname("Sharma");
            session.save(author);

            Author author1=new Author(2,"Kannu","Sharma",20);
            session.save(author1);


            Author author2=new Author(3,"Kunal","Sharma",23);
            session.save(author2);

            Author readAuthor1=session.get(Author.class,1);
            System.out.println(readAuthor1);

            Author readAuthor2=session.get(Author.class,2);
            System.out.println(readAuthor2);

            Author readAuthor3=session.get(Author.class,3);
            System.out.println(readAuthor3);

            author1.setLastname("updatedLastname");
            session.update(author1);

//          Delete
            session.delete(author2);
            session.delete(author1);
            session.delete(author);


            Address address =new Address("2121","abc","Delhi");

            List<String> subjects=new ArrayList<>(3);
            subjects.add("Subject1");
            subjects.add("Subject2");
            subjects.add("Subject3");


            Author author3=new Author(4,"abc","Sharma",23);
            author3.setDob(new Date());
            author3.setSubjects(subjects);
            author3.setAddress(address);

            Author author4=new Author(5,"xcq","Sharma",23);
            author4.setDob(new Date());
            author4.setSubjects(subjects);
            author4.setAddress(address);

            Author author5=new Author(6,"qwqw","Sharma",23);
            author5.setDob(new Date());
            author5.setSubjects(subjects);
            author5.setAddress(address);

            Collection<Author> authors=new HashSet<Author>();
            authors.add(author3);
            authors.add(author4);
            authors.add(author5);


            Book book1=new Book("Book1",authors);
            Book book2=new Book("Book2",authors);
            Book book5=new Book("Book5",authors);
            Book book6=new Book("Book6",authors);
            Book book7=new Book("Book7",authors);
            Book book8=new Book("Book8",authors);

            session.save(book1);
            session.save(book2);
            session.save(book5);
            session.save(book6);
            session.save(book7);
            session.save(book8);


            Collection<Book> books=new HashSet<Book>();
            books.add(book1);
            books.add(book2);

            Collection<Book> books1=new HashSet<Book>();
            books1.add(book5);
            books1.add(book6);

            Collection<Book> books2=new HashSet<Book>();
            books2.add(book7);
            books2.add(book8);

            author3.setBooks(books);
            author4.setBooks(books1);
            author5.setBooks(books2);

            session.save(author3);
            session.save(author4);
            session.save(author5);


            session.getTransaction().commit();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
    }
}