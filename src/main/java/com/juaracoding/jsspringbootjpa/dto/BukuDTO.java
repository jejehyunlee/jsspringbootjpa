package com.juaracoding.jsspringbootjpa.dto;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 23:06
@Last Modified 2/20/2023 23:06
Version 1.0
*/

public class BukuDTO {

    private Long idBuku;
    private String namaBuku;
    private String deskripsiBuku;

    public Long getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Long idBuku) {
        this.idBuku = idBuku;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public String getDeskripsiBuku() {
        return deskripsiBuku;
    }

    public void setDeskripsiBuku(String deskripsiBuku) {
        this.deskripsiBuku = deskripsiBuku;
    }
}

