package com.juaracoding.jsspringbootjpa.dto;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 23:11
@Last Modified 2/20/2023 23:11
Version 1.0
*/


import java.util.List;

public class KategoriBukuDTO {

    private Long idKategoriBuku;
    private String namaKategoriBuku;
    private String deskripsiKategoriBuku;
    private List<BukuDTO> listBuku;

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

    public List<BukuDTO> getListBuku() {
        return listBuku;
    }

    public void setListBuku(List<BukuDTO> listBuku) {
        this.listBuku = listBuku;
    }
}

