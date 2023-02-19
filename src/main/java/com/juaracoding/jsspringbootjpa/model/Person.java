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
import java.util.Date;

@Entity
@Table(name ="MstPerson")
public class Person{
    @Id
    @Column(name = "IDPerson",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    //Start AuditTrail
    @Column(name = "CreatedDate",nullable = false)
    private Date createdDate = new Date();

    @Column(name = "CreatedBy", nullable = false)
    private Integer createdBy;

    @Column(name = "ModifiedDate")
    private Date modifiedDate;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Column ( name = "IsDeleted", nullable = false )
    private Byte isDeleted = 1;
    //End AuditTrail


    public Person() {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
