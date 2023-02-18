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


import com.juaracoding.jsspringbootjpa.configuration.OtherConfig;
import com.juaracoding.jsspringbootjpa.dto.CategoryProductDTO;
import com.juaracoding.jsspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.jsspringbootjpa.handler.ResponseHandler;
import com.juaracoding.jsspringbootjpa.model.CategoryProduct;
import com.juaracoding.jsspringbootjpa.service.CategoryService;
import com.juaracoding.jsspringbootjpa.utils.ConstantMessage;
import com.juaracoding.jsspringbootjpa.utils.CsvReader;
import com.juaracoding.jsspringbootjpa.utils.LoggingFile;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@RestController
@RequestMapping("api/mgmnt")

public class CategoryProductController {

    private CategoryService categoryService;

    private String [] strExceptionArr = new String[2];

    @Autowired
    private ModelMapper modelMapper;

    private Map<String,Object> objectMapper = new HashMap<String,Object>();
    List<CategoryProduct> lsCPUpload = new ArrayList<CategoryProduct>();

    @Autowired
    public CategoryProductController(CategoryService categoryService) {
        strExceptionArr[0] = "CategoryProductController";
        this.categoryService = categoryService;
    }

    @PostMapping("/v1/s")
    public ResponseEntity<Object> saveCategoryProduct(@Valid @RequestBody CategoryProduct categoryProduct) {
        categoryService.saveDataCategory(categoryProduct);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_SAVE,
                        HttpStatus.OK,
                        null,
                        null,
                        null);

    }

    @PostMapping("/v1/sl")
    public ResponseEntity<Object> saveAllCategoryProduct(@Valid @RequestBody List<CategoryProduct> categoryProductList) {
        categoryService.saveAllDataCategory(categoryProductList);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.OK, null, null, null);
    }

    @PostMapping("/v1/sl/{id}")
    public ResponseEntity<Object> updateCategoryProduct(@Valid @RequestBody CategoryProduct categoryProduct, @PathVariable Long id) throws Exception {

        categoryService.updateCategoryProduct(categoryProduct, id);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.OK, null, null, null);
    }

    @GetMapping("/v1/f")
    public ResponseEntity<Object> findAll() {

        List<CategoryProduct> categoryProductList = categoryService.findAllCategoryProduct();

        if (categoryProductList.size() == 0) {

            return new ResponseHandler().
                    generateResponse(ConstantMessage.WARNING_NOT_FOUND,
                            HttpStatus.NOT_FOUND,
                            categoryService.findAllCategoryProduct(),
                            null,
                            null);
        }
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,
                        HttpStatus.OK,
                        categoryService.findAllCategoryProduct(),
                        null,
                        null);

    }

    @GetMapping("/v1/f/{size}/{page}/{sort}")
    public ResponseEntity<Object> pagination(
            @PathVariable("size") Integer size,
            @PathVariable("page") Integer page,
            @PathVariable("sort") String sort
    ) {

        Pageable pageable = null;
        if (sort.equalsIgnoreCase("desc")) {

            pageable = PageRequest.of(page, size, Sort.by("idCategoryProduct").descending());

        } else {
            pageable = PageRequest.of(page, size);

        }


//        Page<CategoryProduct> categoryProductsPage = categoryService.findByCategoryPage(pageable);

//        if (categoryProductsPage.size()==0){
//
//            return new ResponseHandler().
//                    generateResponse(ConstantMessage.WARNING_NOT_FOUND,
//                            HttpStatus.NOT_FOUND,
//                            categoryService.findAllCategoryProduct(),
//                            null,
//                            null);
//        }
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,
                        HttpStatus.OK,
                        categoryService.findByCategoryPage(pageable),
                        null,
                        null);

    }


    //Pagination SortBy
    @GetMapping("/v1/fpsb1/{size}/{page}/{sort}/{sortby}")
    public ResponseEntity<Object> paginationSortBy(
            @PathVariable("size") Integer size,
            @PathVariable("page") Integer page,
            @PathVariable("sort") String sort,
            @PathVariable("sortby") String sortBy
    ) {

        Pageable pageable = null;
        String strSortBy = "";
        if (sortBy.equalsIgnoreCase("id")) {

            strSortBy = "idCategoryProduct";

        } else if (sortBy.equalsIgnoreCase("name")) {
            strSortBy = "nameCategoryProduct";

        } else if (sortBy.equalsIgnoreCase("desc")) {
            strSortBy = "descCategoryProduct";

        } else {
            strSortBy = "idCategoryProduct";
        }

        if (sort.equalsIgnoreCase("desc")) {
            pageable = PageRequest.of(page, size, Sort.by(strSortBy).descending());
        } else {
            pageable = PageRequest.of(page, size, Sort.by(strSortBy).ascending());
        }


        Page<CategoryProduct> categoryProductsPage = categoryService.findByCategoryPage(pageable);
        List<CategoryProduct> categoryProductList = categoryProductsPage.getContent();
        if (categoryProductList.size() == 0) {

            return new ResponseHandler().
                    generateResponse(ConstantMessage.WARNING_DATA_EMPTY,
                            HttpStatus.NOT_FOUND,
                            categoryService.findAllCategoryProduct(),
                            null,
                            null);
        }
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,
                        HttpStatus.OK,
                        categoryProductList,
                        null,
                        null);

    }

    @GetMapping("/v1/fpsbd2/{size}/{page}/{sort}/{sortby}")
    public ResponseEntity<Object> findPaginationSortByDTO2(
            @PathVariable("size") Integer sizez,
            @PathVariable("page") Integer pagez,
            @PathVariable("sort") String sortz,
            @PathVariable("sortby") String sortzBy
    ){

        Pageable pageable = filterPagination(pagez,sizez,sortz,sortzBy);
        Page<CategoryProduct> page = categoryService.findByCategoryPage(pageable);
        List<CategoryProduct> listCategoryProduct = page.getContent();

        /*
            CATATAN PENTING!!
            VALIDASI INI DILETAKKAN DISINI AGAR TIDAK PERLU MELAKUKAN PROSES APAPUN (PROSES MAPPING ATAU TRANSFORM DTO) JIKA DATA YANG DICARI KOSONG
         */
        if(listCategoryProduct.size()==0)
        {
            return new ResponseHandler().
                    generateResponse(ConstantMessage.WARNING_DATA_EMPTY,
                            HttpStatus.NOT_FOUND,
                            null,
                            null,
                            null);
        }

        List<CategoryProductDTO> listCategoryProductDTO = modelMapper.map(listCategoryProduct, new TypeToken<List<CategoryProductDTO>>() {}.getType());
        Map<String, Object> mapResult = transformObject(objectMapper,listCategoryProductDTO,page);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,
                        HttpStatus.OK,
                        mapResult,
                        null,
                        null);
    }

    private Map<String,Object> transformObject(Map<String,Object> mapz, List ls, Page page)
    {
        mapz.put("data",ls);
        mapz.put("currentPage",page.getNumber());
        mapz.put("totalItems",page.getTotalElements());
        mapz.put("totalPages",page.getTotalPages());
        mapz.put("sort",page.getSort());
        mapz.put("numberOfElements",page.getNumberOfElements());

        return mapz;
    }

    private Pageable filterPagination(Integer page, Integer size, String sorts , String sortsBy)
    {
        Pageable pageable;
        String strSortBy = "";

        if(sortsBy.equalsIgnoreCase("id"))
        {
            strSortBy = "idCategoryProduct";
        }
        else if(sortsBy.equalsIgnoreCase("name"))
        {
            strSortBy = "nameCategoryProduct";
        }
        else if(sortsBy.equalsIgnoreCase("description"))
        {
            strSortBy = "strDescCategoryProduct";
        }
        else
        {
            strSortBy = "idCategoryProduct";
        }

        if(sorts.equalsIgnoreCase("desc"))
        {
            pageable = PageRequest.of(page,size, Sort.by(strSortBy).descending());
        }
        else
        {
            pageable = PageRequest.of(page,size, Sort.by(strSortBy).ascending());
        }

        return pageable;
    }






    @PostMapping("/v1/upl/batch")
    public ResponseEntity<Object> uploadCsvMaster(@Valid
                                                  @RequestParam("fileDemo")
                                                  @RequestHeader MultipartFile multipartFile,
                                                  WebRequest request
    ) throws Exception {

        if (CsvReader.isCsv(multipartFile)) {
            return categoryService.saveUploadFile(
                    csvToCategoryProduct(
                            multipartFile.getInputStream()), multipartFile, request);
        } else {
            return new ResponseHandler().generateResponse(ConstantMessage.ERROR_NOT_CSV_FILE + " -- " + multipartFile.getOriginalFilename(),
                    HttpStatus.NOT_ACCEPTABLE, null, "FI01021", request);
        }

    }

    public List<CategoryProduct> csvToCategoryProduct(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        CSVParser csvParser = new CSVParser(bufferedReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().
                        withIgnoreHeaderCase()
        );
//        lsCPUpload = new ArrayList<CategoryProduct>();
        lsCPUpload.clear();
        int intCatchErrorRecord = 1;
        try {
            Iterable<CSVRecord> iterRecords = csvParser.getRecords();

            for (CSVRecord record : iterRecords) {
                CategoryProduct cProducts = new CategoryProduct();
                cProducts.setNameCategoryProduct(record.get("NameCategoryProduct"));
                cProducts.setDescCategoryProduct(record.get("DescCategoryProduct"));
                cProducts.setCreatedBy(Integer.parseInt(record.get("CreatedBy")));
                lsCPUpload.add(cProducts);
                intCatchErrorRecord++;
            }

        } catch (Exception ex) {
            strExceptionArr[1]="csvToCategoryProduct(InputStream inputStream) --- LINE 530"+ex.getMessage()+" Error Record at Line "+intCatchErrorRecord;
            LoggingFile.exceptionStringz(strExceptionArr,ex, OtherConfig.getFlagLogging());
            throw new Exception(ex.getMessage()+" Error Record at Line "+intCatchErrorRecord);
        }
        finally {
            if (!csvParser.isClosed()) {
                csvParser.close();
            }
        }
        return lsCPUpload;
    }

    public List<CategoryProduct> excelToCategoryProduct(InputStream inputStream) throws Exception {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("page-1");
//        Sheet sheetOne = workbook.getSheet("page-1");
//        Sheet sheetTwo = workbook.getSheet("page-2");
        Iterator<Row> rows = sheet.iterator();

        lsCPUpload.clear();
        int intCatchErrorRecord = 0;
        int intNextCell = 0;

        try {

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                Iterator<Cell> cellsInRow = currentRow.iterator();

                if(intCatchErrorRecord!=0){//MENGABAIKAN HEADER
                    intNextCell = 0;

                    CategoryProduct cProducts = new CategoryProduct();

                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();
                        /*
                            URUTAN nya harus dimapping sesuai dengan cell di file excel nya !! dimulai dari index 0
                         */
                        if(intNextCell==0)
                        {
                            cProducts.setNameCategoryProduct(currentCell.getStringCellValue());
                        }
                        else if(intNextCell==1)
                        {
                            cProducts.setDescCategoryProduct(currentCell.getStringCellValue());
                        }
                        else
                        {
                            cProducts.setCreatedBy((int) currentCell.getNumericCellValue());
                        }

                        intNextCell++;
                    }
                    lsCPUpload.add(cProducts);
                }
                intCatchErrorRecord++;
            }

        } catch (Exception ex) {
            strExceptionArr[1]="excelToCategoryProduct(InputStream inputStream) ---LINE 589";
//            System.out.println(WhatsappConfig.getAuth());
            LoggingFile.exceptionStringz(strExceptionArr,new ResourceNotFoundException(ex.getMessage()+" Error Record at Line "+intCatchErrorRecord), OtherConfig.getFlagLogging());
            throw new Exception(ex.getMessage()+" Error Record at Line "+intCatchErrorRecord);
        }
        finally
        {
            workbook.close();
        }
        return lsCPUpload;
    }


}