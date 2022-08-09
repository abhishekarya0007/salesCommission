package com.commission.commission.controller;

import com.commission.commission.entity.SalesLineItem;
import com.commission.commission.helper.myExcelHelper;
import com.commission.commission.service.excelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class salesLineItem {

    @Autowired
    private excelService excelService;

    @PostMapping("/Admin/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if(myExcelHelper.checkExcelFormat(file))
        {
            this.excelService.save(file);
            return ResponseEntity.ok(Map.of("message","File is uploaded and data is set to DB"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel File");
    }

    @GetMapping("/Admin/salesLineItems")
    public List<SalesLineItem> getAllsalesLineItems()
    {
        return this.excelService.getAllSalesLineItems();
    }
}
