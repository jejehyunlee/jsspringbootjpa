package com.juaracoding.jsspringbootjpa.model;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/14/2023 03:14
@Last Modified 2/14/2023 03:14
Version 1.0
*/


import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table (name = "MstCategoryProduct")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCategoryProduct", nullable = false)
    private Long idCategoryProduct;

    @Column(name = "NameCategoryProduct", nullable = false, length = 40)
    @Length(message = ConstantMessage.MAX_CHAR_NAME_CATPROD, max = 40)
    @NotEmpty(message = ConstantMessage.CHAR_NAME_NOTEMPY)
    private String nameCategoryProduct;

    @Column(name = "DescCategoryProduct", nullable = false, length = 500)
    @NotEmpty(message = ConstantMessage.CHAR_DESC_NOTEMPTY)
    private String descCategoryProduct;

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


    public CategoryProduct() {
    }

    public Long getIdCategoryProduct() {
        return idCategoryProduct;
    }

    public void setIdCategoryProduct(Long idCategoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
    }

    public String getNameCategoryProduct() {
        return nameCategoryProduct;
    }

    public void setNameCategoryProduct(String nameCategoryProduct) {
        this.nameCategoryProduct = nameCategoryProduct;
    }

    public String getDescCategoryProduct() {
        return descCategoryProduct;
    }

    public void setDescCategoryProduct(String descCategoryProduct) {
        this.descCategoryProduct = descCategoryProduct;
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

