package com.juaracoding.jsspringbootjpa.repo;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 23:13
@Last Modified 2/20/2023 23:13
Version 1.0
*/


import com.juaracoding.jsspringbootjpa.model.KategoriBuku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriBukuRepo extends JpaRepository<KategoriBuku, Long> {
}
