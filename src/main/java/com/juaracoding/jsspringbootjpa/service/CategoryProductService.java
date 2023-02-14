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

import com.juaracoding.jsspringbootjpa.model.CategoryProduct;
import com.juaracoding.jsspringbootjpa.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryProductService {

    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryProductService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void saveDataCategory(CategoryProduct categoryProduct){

        categoryRepo.save(categoryProduct);
    }

    public void saveAllDataCategory(List<CategoryProduct> listCategoryProduct){
        categoryRepo.saveAll(listCategoryProduct);
    }


    /*
    Select * From MstCateogryProduct
     */
    public List<CategoryProduct> findAllCateoryProduct(){

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
   public void updateCategoryProduct(CategoryProduct categoryProduct, long id){

        Optional<CategoryProduct> opt = categoryRepo.findById(id);
   }

}
