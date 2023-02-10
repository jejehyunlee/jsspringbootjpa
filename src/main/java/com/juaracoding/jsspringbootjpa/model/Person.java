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
public class Person {
    @Id
    @Column(name = "IDPerson",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "CreateBy")
    private String CreateBy;
    @Column(name = "ModifiedBy")
    private String ModifiedBy;

    @Column(name = "IsDelete")
    private String IsDelete ;

    public Person(long id, String username, String firstname, String lastname, String createBy, String modifiedBy, String isDelete) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        CreateBy = createBy;
        ModifiedBy = modifiedBy;
        IsDelete = isDelete;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String createBy) {
        CreateBy = createBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(String isDelete) {
        IsDelete = isDelete;
    }
}
