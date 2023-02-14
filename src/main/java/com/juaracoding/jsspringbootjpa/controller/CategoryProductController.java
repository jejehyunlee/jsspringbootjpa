package com.juaracoding.jsspringbootjpa.controller;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 2/14/2023 08:50
@Last Modified 2/14/2023 08:50
Version 1.0
*/


import com.juaracoding.jsspringbootjpa.model.CategoryProduct;
import com.juaracoding.jsspringbootjpa.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/mgmnt")
public class CategoryProductController {

    private CategoryProductService categoryService;

    @Autowired
    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryService = categoryProductService;
    }

    @PostMapping("/v1/s")
    public void saveCategoryProduct(@Valid @RequestBody CategoryProduct categoryProduct)
    {
        categoryService.saveDataCategory(categoryProduct);


    }
    @PostMapping("/v1/sl")
    public void saveAllCategoryProduct(@Valid @RequestBody List<CategoryProduct> categoryProductList)
    {
        categoryService.saveAllDataCategory(categoryProductList);
    }

    @PostMapping("/v1/sl/{id}")
    public void updateCategoryProduct(@Valid @RequestBody CategoryProduct categoryProduct, @PathVariable Long id) throws Exception{

        categoryService.updateCategoryProduct(categoryProduct, id);
    }
}
