package com.hibernate.bookrecord.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name="reader_name")
    private String readerName;

    @Embedded
    private Address homeAddress;
    
    @AttributeOverrides({
            @AttributeOverride(name="street",column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name="city",column = @Column(name ="BILLING_CITY")),
            @AttributeOverride(name="zipcode",column = @Column(name ="BILLING_ZIPCODE"))
    })
    private Address billingAddress;

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Reader(String readerName, Address homeAddress) {
        this.readerName = readerName;
        this.homeAddress = homeAddress;
    }

    public Reader() {
    }

    @Override
    public String toString() {
        return "Reader{" +
                "Id=" + Id +
                ", readerName='" + readerName + '\'' +
                ", homeAddress=" + homeAddress +
                '}';
    }
}








