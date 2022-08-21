package com.commission.commission.controller;

import com.commission.commission.entity.SalesLineItem;
import com.commission.commission.helper.myExcelHelper;
import com.commission.commission.service.excelService;
import com.commission.commission.service.salesLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class salesLineItemController {

    @Autowired
    private excelService excelService;
    @Autowired
    private com.commission.commission.service.salesLineItemService salesLineItemService;

    @PostMapping("/admin/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if(myExcelHelper.checkExcelFormat(file))
        {
            this.excelService.save(file);
            return ResponseEntity.ok(Map.of("message","File is uploaded and data is set to DB"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel File");
    }

    @GetMapping("/admin/salesLineItems")
    public List<SalesLineItem> getAllsalesLineItems()
    {
        return this.excelService.getAllSalesLineItems();
    }
    @GetMapping("user/salesByMonth")
    public List<SalesLineItem> salesByMonth(@RequestParam("sid") int sid, @RequestParam("month") int month)
    {
        return salesLineItemService.salesByMonth(sid,month);
    }
    @PostMapping("/admin/addSalesLineItem")
    public SalesLineItem addSalesPerson(@RequestBody SalesLineItem salesLineItem){

        return salesLineItemService.addSalesLineItem(salesLineItem);

    }
}
