package com.hibernate.bookrecord;

import com.hibernate.bookrecord.entity.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class GetReaderBooks {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure(new File("C:\\Users\\semir\\IdeaProjects\\bookrecord\\src\\main\\resource\\hibernate.cfg.xml")).addAnnotatedClass(Reader.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        try {
            // start a transaction
            session.beginTransaction();
            // get the student id
            int theId= 102;
            Reader reader = session.get(Reader.class, theId);
            //print the student detail
            System.out.println("Reader Details: " +reader);
            //print the associated image
            System.out.println("The associated books: " +reader.getBooks());
            //commit the transaction
            session.getTransaction().commit();
            //done
            System.out.println("Done!");
        }finally {
            //close the transaction
            session.close();
            factory.close();
        }
    }
}
