package com.juaracoding.jsspringbootjpa.repo;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/14/2023 03:36
@Last Modified 2/14/2023 03:36
Version 1.0
*/


import com.juaracoding.jsspringbootjpa.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryProduct, Long> {

//List<CategoryProduct> findByCategoryProduct(String Value);

}
