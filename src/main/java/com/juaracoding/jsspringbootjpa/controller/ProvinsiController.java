package com.juaracoding.jsspringbootjpa.controller;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/19/2023 15:57
@Last Modified 2/19/2023 15:57
Version 1.0
*/

import com.juaracoding.jsspringbootjpa.handler.ResponseHandler;
import com.juaracoding.jsspringbootjpa.model.CategoryProduct;
import com.juaracoding.jsspringbootjpa.model.Provinsi;
import com.juaracoding.jsspringbootjpa.service.ProvinsiService;
import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/mgmnt/state")
public class ProvinsiController {

    private ProvinsiService provinsiService;

    public ProvinsiController(ProvinsiService provinsiService) {
        this.provinsiService = provinsiService;
    }

    //SaveOne
    @PostMapping("/v1/s")
    public ResponseEntity<Object> saveProvinsi(@Valid @RequestBody Provinsi provinsi) {
        provinsiService.saveDataProvinsi(provinsi);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_SAVE,
                        HttpStatus.OK,
                        null,
                        null,
                        null);

    }

    //SaveAll
    @PostMapping("/v1/sl")
    public ResponseEntity<Object> saveAllProvinsi(@Valid @RequestBody List<Provinsi> provinsiList) {
        provinsiService.saveAllDataProvinsi(provinsiList);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.OK, null, null, null);
    }



}
