package com.juaracoding.jsspringbootjpa.repo;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 22:53
@Last Modified 2/20/2023 22:53
Version 1.0
*/


import com.juaracoding.jsspringbootjpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
