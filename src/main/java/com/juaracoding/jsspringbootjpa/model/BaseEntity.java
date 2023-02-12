package com.juaracoding.jsspringbootjpa.model;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/12/2023 00:53
@Last Modified 2/12/2023 00:53
Version 1.0
*/


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<T> {

    @CreatedBy
    @Column(name = "CreatedBy")
    private T createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column( name = "CreatedDate", nullable = false )
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "UpdateBy")
    private T updateBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column ( name = "UpdatedDate" )
    private Date updatedDate;

    @Column ( name = "IsDeleted", nullable = false )
    private Boolean isDeleted = Boolean.TRUE;

    public BaseEntity() {
    }

    public BaseEntity(T createdBy, Date createdDate, T updateBy, Date updatedDate, Boolean isDeleted) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updateBy = updateBy;
        this.updatedDate = updatedDate;
        this.isDeleted = isDeleted;
    }

    public T getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(T createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public T getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(T updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}

