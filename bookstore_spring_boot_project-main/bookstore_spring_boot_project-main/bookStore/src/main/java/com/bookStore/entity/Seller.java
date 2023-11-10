package com.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String contactPerson;
    private String email;
    private String phone;
    private String address;

    public Seller () {
    }

    public Seller (Long id, String companyName, String contactPerson, String email, String phone, String address) {
        this.id = id;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId () {return id;}

    public void setId (Long id) {this.id = id;}

    public String getCompanyName () {return companyName;}

    public void setCompanyName (String companyName) {this.companyName = companyName;}

    public String getContactPerson () {return contactPerson;}

    public void setContactPerson (String contactPerson) {this.contactPerson = contactPerson;}

    public String getEmail () {return email;}

    public void setEmail (String email) {this.email = email;}

    public String getPhone () {return phone;}

    public void setPhone (String phone) {this.phone = phone;}

    public String getAddress () {return address;}

    public void setAddress (String address) {this.address = address;}
}
