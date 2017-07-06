package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
public class Book {

    @Id
    String bookName;

    @ManyToMany
    Collection<Author> authors;

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }


    public Book() {
    }

    public Book(String bookName, Collection<Author> authors) {
        this.bookName = bookName;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
