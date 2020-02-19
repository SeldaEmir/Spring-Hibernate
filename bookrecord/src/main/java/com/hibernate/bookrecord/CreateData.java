package com.hibernate.bookrecord;

import com.hibernate.bookrecord.entity.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateData {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure(new File("C:\\Users\\semir\\IdeaProjects\\bookrecord\\src\\main\\resource\\hibernate.cfg.xml")).addAnnotatedClass(Reader.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        try {
            //create the object
            Reader reader = new Reader();
            reader.setReaderName("Selda");

            Map<String,String> books = reader.getBooks();
            books.put("Sefiller","Victor Hugo");
            books.put("Suç ve Ceza","Fyodor Dostoyevski");
            books.put("Insanciklar","Fyodor Dostoyevski");

            //start transaction
            session.beginTransaction();
            //save the object
            System.out.println("Saving the books and readers..");
            session.persist(reader);
            //session.save(books);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done..");
        } finally {
            //clean up code
            session.close();
            factory.close();
        }
    }
}
