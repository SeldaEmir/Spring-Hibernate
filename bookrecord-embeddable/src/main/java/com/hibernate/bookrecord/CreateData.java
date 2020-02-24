package com.hibernate.bookrecord;

import com.hibernate.bookrecord.entity.Address;
import com.hibernate.bookrecord.entity.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.File;

public class CreateData {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure(new File("C:\\Users\\semir\\IdeaProjects\\bookrecord\\src\\main\\resource\\hibernate.cfg.xml")).addAnnotatedClass(Reader.class).addAnnotatedClass(Address.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        try {
            //create the object
            Reader reader = new Reader();
            reader.setReaderName("Selda");

            //create the Address object
            Address homeAddress= new Address();
            homeAddress.setCity("Bayrampasa");
            homeAddress.setStreet("Merkez Sokak");
            homeAddress.setZipcode("34045");
            //save the object
            System.out.println("Saving the reader and address..");
            reader.setHomeAddress(homeAddress);
            //start transaction
            session.beginTransaction();
            session.persist(reader);

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
