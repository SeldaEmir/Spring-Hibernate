package com.hibernate.bookrecord.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SortComparator;


import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="reader_name")
    private String readerName;

    @ElementCollection
    //@CollectionTable(name="book",joinColumns = @JoinColumn(name="reader_id"))
    //@OrderColumn//this used for list
    @CollectionTable(name="book")
    @MapKeyColumn(name = "book_name")  //key alanı //this used for Map
    @OrderBy  //this just order asc automatically (javax.persistence)
    @SortComparator(ReverseStringComparator.class)
    //@org.hibernate.annotations.OrderBy(clause = "book_name desc") // this could be special order asc or desc
    @Column(name="author")  //value alanı
    //private Set<String> books = new HashSet<String>();
    //private List<String> books = new ArrayList<String>();
    //private Map<String,String> books = new HashMap<String, String>();
    //private Set<String> books = new LinkedHashSet<String>();
    private SortedMap<String,String> books = new TreeMap<String, String>();
    public static class ReverseStringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

}








