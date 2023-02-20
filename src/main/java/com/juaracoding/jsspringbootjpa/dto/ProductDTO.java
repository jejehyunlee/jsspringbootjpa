package com.juaracoding.jsspringbootjpa.dto;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 22:57
@Last Modified 2/20/2023 22:57
Version 1.0
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private Long idProduct;
    private String nameProduct;
    private CategoryProductDTO categoryProduct;
    private String descriptionProduct;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public CategoryProductDTO getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProductDTO categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }
}
