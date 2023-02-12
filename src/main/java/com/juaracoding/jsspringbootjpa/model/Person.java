package com.juaracoding.jsspringbootjpa.model;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/10/2023 13:25
@Last Modified 2/10/2023 13:25
Version 1.0
*/

import javax.persistence.*;

@Entity
@Table(name ="MstPerson")
public class Person extends BaseEntity{
    @Id
    @Column(name = "IDPerson",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    public Person() {
    }

    public Person(long id, String username, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
