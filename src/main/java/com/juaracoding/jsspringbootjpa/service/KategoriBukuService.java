package com.juaracoding.jsspringbootjpa.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 23:14
@Last Modified 2/20/2023 23:14
Version 1.0
*/

import com.juaracoding.jsspringbootjpa.configuration.OtherConfig;
import com.juaracoding.jsspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.jsspringbootjpa.handler.ResponseHandler;
import com.juaracoding.jsspringbootjpa.model.KategoriBuku;
import com.juaracoding.jsspringbootjpa.repo.KategoriBukuRepo;
import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import com.juaracoding.jsspringbootjpa.utils.LoggingFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class KategoriBukuService {


    private KategoriBukuRepo kategoriBukuRepo;

    private String [] strExceptionArr = new String[2];

    public KategoriBukuService(KategoriBukuRepo kategoriBukuRepo) {
        this.kategoriBukuRepo = kategoriBukuRepo;
    }


    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Object> saveKategoriBukuList(List<KategoriBuku> listKategoriBuku)
    {

        try {
            kategoriBukuRepo.saveAll(listKategoriBuku);
        }catch (Exception e)
        {

            strExceptionArr[1]="saveKategoriBukuList(List<KategoriBuku> listKategoriBuku) --- LINE 41";
            LoggingFile.exceptionStringz(strExceptionArr,new ResourceNotFoundException(e.getMessage()), OtherConfig.getFlagLogging());
            return new ResponseHandler().
                    generateResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR,null,"FI03001",null);
        }
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Object> saveUploadFile(List<KategoriBuku> listKategoriBuku,
                                                 MultipartFile multipartFile,
                                                 WebRequest request) throws Exception {
        List<KategoriBuku> listKategoriBukuResult = null;
        String strMessage = ConstantMessage.SUCCESS_SAVE;

        try
        {
            listKategoriBukuResult = kategoriBukuRepo.saveAll(listKategoriBuku);
            if(listKategoriBukuResult.size()==0)
            {
                strExceptionArr[1]="saveUploadFile(List<KategoriBuku> listKategoriBuku, MultipartFile multipartFile, WebRequest request) --- LINE 64";
                LoggingFile.exceptionStringz(strExceptionArr,new ResourceNotFoundException("FILE KOSONG"), OtherConfig.getFlagLogging());
                return new ResponseHandler().generateResponse(ConstantMessage.ERROR_EMPTY_FILE +" -- "+multipartFile.getOriginalFilename(),
                        HttpStatus.BAD_REQUEST,null,"FI03002",request);
            }
        }
        catch (Exception e)
        {
            strMessage = e.getMessage();
            strExceptionArr[1]="saveUploadFile(List<KategoriBuku> listKategoriBuku, MultipartFile multipartFile, WebRequest request) --- LINE 74";
            LoggingFile.exceptionStringz(strExceptionArr,e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateResponse(strMessage,
                    HttpStatus.BAD_REQUEST,null,"FI03003",request);
        }

        return new ResponseHandler().generateResponse(strMessage,
                HttpStatus.CREATED,null,null,request);
    }

    public Page<KategoriBuku> findKategoriBukuByPage(Pageable pageable)
    {
        return kategoriBukuRepo.findAll(pageable);
    }

}

