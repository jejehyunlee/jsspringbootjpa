package com.juaracoding.jsspringbootjpa.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/19/2023 15:57
@Last Modified 2/19/2023 15:57
Version 1.0
*/


import com.juaracoding.jsspringbootjpa.model.Provinsi;
import com.juaracoding.jsspringbootjpa.repo.ProvinsiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProvinsiService {

    private ProvinsiRepo provinsiRepo;

    @Autowired
    public ProvinsiService(ProvinsiRepo provinsiRepo) {
        this.provinsiRepo = provinsiRepo;
    }

    //Save DataOne
    @Transactional(rollbackFor = Exception.class)
    public void saveDataProvinsi(Provinsi provinsi){

        provinsiRepo.save(provinsi);
    }

    //Save DataBatch
    @Transactional (rollbackFor = Exception.class)
    public void saveAllDataProvinsi(List<Provinsi> listProvinsi){
        provinsiRepo.saveAll(listProvinsi);
    }


}
