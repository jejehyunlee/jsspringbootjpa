package com.juaracoding.jsspringbootjpa.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 22:54
@Last Modified 2/20/2023 22:54
Version 1.0
*/

import com.juaracoding.jsspringbootjpa.configuration.OtherConfig;
import com.juaracoding.jsspringbootjpa.handler.ResponseHandler;
import com.juaracoding.jsspringbootjpa.model.Product;
import com.juaracoding.jsspringbootjpa.repo.ProductRepo;
import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import com.juaracoding.jsspringbootjpa.utils.LoggingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private ProductRepo productRepo;
    private String [] strExceptionArr = new String[2];

    @Autowired
    public ProductService(ProductRepo productRepo) {
        strExceptionArr[0] = "ProductService";
        this.productRepo = productRepo;
    }

    public ResponseEntity<Object> saveProduct(Product product)
    {
        String strMessage = ConstantMessage.SUCCESS_SAVE;
        try
        {
            productRepo.save(product);
        }
        catch (Exception e)
        {
            strExceptionArr[1]="saveProduct(Product product) --- LINE 38";
            LoggingFile.exceptionStringz(strExceptionArr,e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateResponse(ConstantMessage.ERROR_SAVE_FAILED,
                    HttpStatus.BAD_REQUEST,null,"FI02001",null);
        }

        return new ResponseHandler().generateResponse(strMessage,
                HttpStatus.CREATED,null,null,null);
    }

    public Page<Product> findPageSortBy(Pageable pageable){

        return productRepo.findAll(pageable);
    }

}
