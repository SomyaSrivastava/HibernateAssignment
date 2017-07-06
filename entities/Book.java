package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    String bookName;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
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
