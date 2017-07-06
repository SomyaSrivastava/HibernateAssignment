package entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ Entity
public class Author {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "authorId")
    int id;
    @Column(name = "AuthorName")
    String firstname;
    @ Transient
    String lastname;
    @ Column(name = "AuthorAge")
    int  age;
    @Temporal(TemporalType.DATE)
    Date dob;
    @Embedded
    Address  address;
    @ElementCollection
    List<String> Subjects=new ArrayList<String>(3);

    //Ques.15
    @OneToOne
    @JoinColumn(name="Book_join_column")
    Book book;

    //Ques.16 one to many - unidirectional
//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(joinColumns = @JoinColumn(name="author_id"),
//    inverseJoinColumns = @JoinColumn(name = "book_id"))
//    List<Book> books=new ArrayList<>();

     public Author() {
     }


     public Author(int id, String firstname, String lastname, int age) {
         this.id = id;
         this.firstname = firstname;
         this.lastname = lastname;
         this.age = age;
    }


//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
//

//    Ques15 :
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<String> getSubjects() {
        return Subjects;
    }

     public void setSubjects(List<String> subjects) {
        Subjects = subjects;
    }

     public Address getAddress() {
        return address;
    }

     public void setAddress(Address address) {
        this.address = address;
    }

     public Date getDob() {
        return dob;
    }

     public void setDob(Date dob) {
        this.dob = dob;
    }

     @Override
     public String toString() {
         return "Author{" +
                 "id=" + id +
                 ", firstname='" + firstname + '\'' +
                 ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
