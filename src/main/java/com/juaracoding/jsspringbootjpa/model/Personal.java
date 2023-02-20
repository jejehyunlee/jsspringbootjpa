package com.juaracoding.jsspringbootjpa.model;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 19:43
@Last Modified 2/20/2023 19:43
Version 1.0
*/

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table(name = "MstPersonal")
public class Personal {


    @Id
    @Column(name = "IDPersonal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonal;

    @Column(name = "NamaDepan", nullable = false,length = 30)
    private String namaDepan;

    @Column(name = "NamaBelakang",nullable = true, length = 30)
    private String namaBelakang;

    @Column(name = "Email",nullable = false,length = 50)
    private String email;

    @Column(name = "JenisKelamin" , nullable = false,length = 20)
    private String jenisKelamin;
    @Column(name = "TanggalLahir")
    private LocalDate tanggalLahir;

    @Column(name = "Alamat",nullable = false,length = 255)
    private String alamat;

    @Transient
    private Integer umur;

    @Column(name = "AngkaRandomDesimal",nullable = false)
    private Double angkaRandomDesimal;

    @Column(name = "AngkaRandomBulat",nullable = false)
    private Integer angkaRandomBulat;

    @Column(name ="CreatedDate",nullable = false)
    private Date createdDate = new Date();

    @Column(name = "CreatedBy",nullable = false)
    private Integer createdBy=1;

    @Column(name = "ModifiedDate")
    private Date modifiedDate;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Column(name = "IsDelete")
    private Byte isDelete = 1;




    public Double getAngkaRandomDesimal() {
        return angkaRandomDesimal;
    }

    public void setAngkaRandomDesimal(Double angkaRandomDesimal) {
        this.angkaRandomDesimal = angkaRandomDesimal;
    }

    public Integer getAngkaRandomBulat() {
        return angkaRandomBulat;
    }

    public void setAngkaRandomBulat(Integer angkaRandomBulat) {
        this.angkaRandomBulat = angkaRandomBulat;
    }



    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getUmur() {
        return Period.
                between(this.tanggalLahir,LocalDate.now())
                .getYears();
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
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
