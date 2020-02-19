package com.hibernate.bookrecord.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="book")
public class Books {

        @Id
        @Column(name="reader_id")
        private int isbn;

        @Column(name="book_name")
        private String bookName;

        @Column(name="author")
        private String author;

//    @ManyToMany
//    @JoinTable(name="reader_book",
//            joinColumns =  @JoinColumn(name="book_id"),
//            inverseJoinColumns = @JoinColumn(name="reader_id")
//    )
//        private List<Reader> readers;

    public Books() {

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public List<Reader> getReaders() {
//        return readers;
//    }

//    public void setReaders(List<Reader> readers) {
//        this.readers = readers;
//    }

    public Books(int isbn, String bookName, String author, Set<Reader> readers) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
       // this.readers = (List<Reader>) readers;
    }

    @Override
    public String toString() {
        return "Books{" +
                "isbn=" + isbn +
                ", bookName=" + bookName +
                ", author=" + author +
            //    ", readers=" + readers +
                '}';
    }
}
