package com.juaracoding.jsspringbootjpa.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/14/2023 03:45
@Last Modified 2/14/2023 03:45
Version 1.0
*/

import com.juaracoding.jsspringbootjpa.configuration.OtherConfig;
import com.juaracoding.jsspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.jsspringbootjpa.handler.ResponseHandler;
import com.juaracoding.jsspringbootjpa.model.CategoryProduct;
import com.juaracoding.jsspringbootjpa.repo.CategoryRepo;
import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import com.juaracoding.jsspringbootjpa.utils.LoggingFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    private CategoryRepo categoryRepo;

    private String [] strExceptionArr = new String[2];


    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Transactional (rollbackFor = Exception.class)
    public void saveDataCategory(CategoryProduct categoryProduct){

        categoryRepo.save(categoryProduct);
    }

    @Transactional (rollbackFor = Exception.class)
    public void saveAllDataCategory(List<CategoryProduct> listCategoryProduct){
        categoryRepo.saveAll(listCategoryProduct);
    }


    /*
    Select * From MstCateogryProduct
     */
    public List<CategoryProduct> findAllCategoryProduct(){

        return categoryRepo.findAll();
    }

    /*
        Select * From MstCategoryProduct Page=?, Sort=?, Record=?
        totalRecord = 100
        page =0
        record = 10
        Data balikan = start index 0 -> index 9
     */
   public Page<CategoryProduct> findByCategoryPage(Pageable pageable){

       return categoryRepo.findAll(pageable);
   }

   /*
        Select * From MstCateogryProduct Where id = ? (data balikan 1 / IsEmpty = Null )
    */
   public Optional<CategoryProduct> findById(Long Id){

       return categoryRepo.findById(Id);
   }

  @Transactional
   public void updateCategoryProduct(CategoryProduct categoryProduct, long id) throws Exception{
      CategoryProduct cProduct = categoryRepo.findById(id).orElseThrow (
              ()->  new ResourceNotFoundException("Data tidak ditemukan")
      );


      if (cProduct!=null){
          cProduct.setNameCategoryProduct(categoryProduct.getNameCategoryProduct());
          cProduct.setDescCategoryProduct(categoryProduct.getDescCategoryProduct());
          cProduct.setModifiedBy(categoryProduct.getModifiedBy());
          cProduct.setModifiedDate(new Date());
      }

   }


    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseEntity<Object> saveUploadFile(List<CategoryProduct> listCategoryProduct,
                                                 MultipartFile multipartFile,
                                                 WebRequest request) throws ResourceNotFoundException {
        List<CategoryProduct> categoryProductList = null;
        String strMessage = ConstantMessage.SUCCESS_SAVE;
        try
        {
            categoryProductList = categoryRepo.saveAll(listCategoryProduct);
            if(categoryProductList.size()==0)
            {
//                strExceptionArr[1]="saveUploadFile(List<CategoryProduct> listCategoryProduct, MultipartFile multipartFile, WebRequest request)---LINE67";
//                LoggingFile.exceptionStringz(strExceptionArr,new ResourceNotFoundException(ConstantMessage.ERROR_EMPTY_FILE +" -- "+multipartFile.getOriginalFilename()), OtherConfig.getFlagLogging());
                return new ResponseHandler().generateResponse(ConstantMessage.ERROR_EMPTY_FILE +" -- "+multipartFile.getOriginalFilename(),
                        HttpStatus.BAD_REQUEST,null,"FI01020",request);
            }
        }
        catch (Exception e)
        {
            strMessage = e.getMessage();
            strExceptionArr[1]="saveUploadFile(List<CategoryProduct> listCategoryProduct, MultipartFile multipartFile, WebRequest request) --- LINE 77";
            LoggingFile.exceptionStringz(strExceptionArr,e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateResponse(strMessage,
                    HttpStatus.BAD_REQUEST,null,"FI01021",request);
        }

        return new ResponseHandler().generateResponse(strMessage,
                HttpStatus.CREATED,null,null,request);
    }


}
