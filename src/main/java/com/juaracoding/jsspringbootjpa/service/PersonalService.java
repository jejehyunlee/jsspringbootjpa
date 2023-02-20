package com.juaracoding.jsspringbootjpa.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/20/2023 19:43
@Last Modified 2/20/2023 19:43
Version 1.0
*/



import com.juaracoding.jsspringbootjpa.configuration.OtherConfig;
import com.juaracoding.jsspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.jsspringbootjpa.handler.ResponseHandler;
import com.juaracoding.jsspringbootjpa.model.Personal;
import com.juaracoding.jsspringbootjpa.repo.PersonalRepo;
import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import com.juaracoding.jsspringbootjpa.utils.LoggingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PersonalService {

    private PersonalRepo personalRepo;
    private String [] strExceptionArr = new String[2];

    @Autowired
    public PersonalService(PersonalRepo personalRepo) {
        strExceptionArr[0]="PersonalService";
        this.personalRepo = personalRepo;
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Object> saveUploadFile(List<Personal> listPersonal,
                                                 MultipartFile multipartFile,
                                                 WebRequest request) throws Exception {
        List<Personal> listPersonalResult = null;
        String strMessage = ConstantMessage.SUCCESS_SAVE;

        try
        {
            listPersonalResult = personalRepo.saveAll(listPersonal);
            if(listPersonalResult.size()==0)
            {
                strExceptionArr[1]="saveUploadFile(List<Personal> listPersonal, MultipartFile multipartFile, WebRequest request) --- LINE 49";
                LoggingFile.exceptionStringz(strExceptionArr,new ResourceNotFoundException("FILE KOSONG"), OtherConfig.getFlagLogging());
                return new ResponseHandler().generateResponse(ConstantMessage.ERROR_EMPTY_FILE +" -- "+multipartFile.getOriginalFilename(),
                        HttpStatus.BAD_REQUEST,null,"FI10013",request);
            }
        }
        catch (Exception e)
        {
            strMessage = e.getMessage();
            strExceptionArr[1]="saveUploadFile(List<Personal> listPersonal, MultipartFile multipartFile, WebRequest request) --- LINE 58";
            LoggingFile.exceptionStringz(strExceptionArr,e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateResponse(strMessage,
                    HttpStatus.BAD_REQUEST,null,"FI10014",request);
        }

        return new ResponseHandler().generateResponse(strMessage,
                HttpStatus.CREATED,null,null,request);
    }

    public Page<Personal> findPersonalByPage(Pageable pageable)
    {
        return personalRepo.findAll(pageable);
    }
    public Page<Personal> findByPersonalByPage(Pageable pageable,String columnFirst,String valueFirst)
    {
        if(columnFirst.equalsIgnoreCase("name"))
        {
            return personalRepo.findByNamaDepan(pageable,valueFirst);
        }
        else if(columnFirst.equalsIgnoreCase("nbelakang"))
        {

            return personalRepo.findByNamaBelakang(pageable,valueFirst);
        }
        else if(columnFirst.equalsIgnoreCase("birth"))
        {
            return personalRepo.findByNamaBelakang(pageable,valueFirst);
        }
        else if(columnFirst.equalsIgnoreCase("angka1"))
        {
            return personalRepo.findByAngkaRandomDesimal(pageable,valueFirst);
        }
        else if(columnFirst.equalsIgnoreCase("angka2"))
        {
            return personalRepo.findByAngkaRandomBulat(pageable,valueFirst);

        }
        else
        {
            return personalRepo.findByNamaDepan(pageable,valueFirst);
        }
    }

    public Page<Personal> findByWDPersonalByPage(Pageable pageable, String columnFirst, String valueFirst, LocalDate dateFrom, LocalDate dateTo)
    {
        if(columnFirst.equalsIgnoreCase("name"))
        {
            return personalRepo.findByNamaDepanAndTanggalLahirBetween(pageable,valueFirst,dateFrom,dateTo);
        }
        else if(columnFirst.equalsIgnoreCase("nbelakang"))
        {
            return personalRepo.findByNamaBelakangAndTanggalLahirBetween(pageable,valueFirst,dateFrom,dateTo);
        }
        else if(columnFirst.equalsIgnoreCase("angka1"))
        {
            return personalRepo.findByAngkaRandomDesimalAndTanggalLahirBetween(pageable,Double.parseDouble(valueFirst),dateFrom,dateTo);
        }
        else if(columnFirst.equalsIgnoreCase("angka2"))
        {
            return personalRepo.findByAngkaRandomBulatAndTanggalLahirBetween(pageable,Integer.parseInt(valueFirst),dateFrom,dateTo);
        }
        else
        {
            return personalRepo.findByNamaDepan(pageable,valueFirst);
        }
    }

}



