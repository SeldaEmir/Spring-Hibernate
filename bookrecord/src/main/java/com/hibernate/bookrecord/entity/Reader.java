package com.hibernate.bookrecord.entity;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="reader_name")
    private String readerName;

    @ElementCollection
    @CollectionTable(name="book",joinColumns = @JoinColumn(name="reader_id"))
    //@OrderColumn//this used for list
    @MapKeyColumn(name = "book_name")  //key alanı
    @Column(name="author")  //value alanı
    //private Set<String> books = new HashSet<String>();
    //private List<String> books = new ArrayList<String>();
    private Map<String,String> books = new HashMap<String, String>();

    public Reader() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public Map<String, String> getBooks() {
        return books;
    }

    public void setBooks(Map<String, String> books) {
        this.books = books;
    }

    public Reader(String readerName) {
        this.readerName = readerName;
    }

    @Override
    public String toString() {
        return "Readers{" +
                "Id=" + Id +
                ", readerName=" + readerName +
                '}';
    }
}
