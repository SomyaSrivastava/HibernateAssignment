import entities.Address;
import entities.Author;
import entities.Book;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;


import javax.persistence.metamodel.EntityType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

            Book book1=new Book("Book1");
            session.save(book1);
            Book book2=new Book("Book2");
            session.save(book2);
            Book book3=new Book("Book3");
            session.save(book3);
            Book book4=new Book("Book4");
            session.save(book4);

            List<Book>books = new ArrayList<>();
            books.add(book1);
            books.add(book2);
            books.add(book3);
            books.add(book4);

            Author author3=new Author(4,"abc","Sharma",23);
            author3.setDob(new Date());
            author3.setSubjects(subjects);
            author3.setBook(book1);
//            author3.setBooks(books);

            author3.setAddress(address);
            session.save(author3);

            Author author4=new Author(5,"xcq","Sharma",23);
            author4.setDob(new Date());
            author4.setBook(book2);
//            author4.setBooks(books);
            author4.setSubjects(subjects);
            author4.setAddress(address);
            session.save(author4);

            Author author5=new Author(6,"qwqw","Sharma",23);
            author5.setDob(new Date());
            author5.setSubjects(subjects);
            author5.setBook(book3);
//            author5.setBooks(books);
            author5.setAddress(address);
            session.save(author5);

            Author author6=new Author(7,"qqq","Sharma",23);
            author6.setDob(new Date());
            author6.setSubjects(subjects);
            author6.setBook(book4);
//            author6.setBooks(books);
            author6.setAddress(address);
            session.save(author6);


            session.getTransaction().commit();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
    }
}