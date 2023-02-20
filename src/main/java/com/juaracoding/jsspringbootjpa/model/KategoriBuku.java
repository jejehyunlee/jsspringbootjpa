package com.juaracoding.jsspringbootjpa.model;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 23:12
@Last Modified 2/20/2023 23:12
Version 1.0
*/

import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MstKategoriBuku")
public class KategoriBuku {

    @Id
    @Column(name = "IDKategoriBuku")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKategoriBuku;

    @NotNull(message = ConstantMessage.WARNING_NAMA_KATBUK_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_NAMA_KATBUK_EMPTY)
    @Length(message = ConstantMessage.WARNING_NAMA_KATBUK_MAX,max = 50)
    @Column(name = "NamaKategoriBuku" ,nullable = false,length = 50)
    private String namaKategoriBuku;


    @NotNull(message = ConstantMessage.WARNING_DESKRIPSI_KATBUK_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DESKRIPSI_KATBUK_EMPTY)
    @Length(message = ConstantMessage.WARNING_NAMA_KATBUK_EMPTY, max = 100)
    @Column(name = "DeskripsiKategoriBuku", nullable = false,length = 100)
    private String deskripsiKategoriBuku;


    @OneToMany
    @JoinColumn(name = "IDKategoriBuku")
    private List<Buku> listBuku;

    /*
      start audit trails
   */
    @Column(name ="CreatedDate" , nullable = false)
    private Date createdDate = new Date();

    @Column(name = "CreatedBy", nullable = false)
    private Integer createdBy;

    @Column(name = "ModifiedDate")
    private Date modifiedDate;
    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Column(name = "IsDelete", nullable = false)
    private Byte isDelete = 1;
    /*
        end audit trails
     */

    public Long getIdKategoriBuku() {
        return idKategoriBuku;
    }

    public void setIdKategoriBuku(Long idKategoriBuku) {
        this.idKategoriBuku = idKategoriBuku;
    }

    public String getNamaKategoriBuku() {
        return namaKategoriBuku;
    }

    public void setNamaKategoriBuku(String namaKategoriBuku) {
        this.namaKategoriBuku = namaKategoriBuku;
    }

    public String getDeskripsiKategoriBuku() {
        return deskripsiKategoriBuku;
    }

    public void setDeskripsiKategoriBuku(String deskripsiKategoriBuku) {
        this.deskripsiKategoriBuku = deskripsiKategoriBuku;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}

