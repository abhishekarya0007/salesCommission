package com.commission.commission.controller;

import com.commission.commission.entity.ProductType;
import com.commission.commission.service.productTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class productTypeController {

    @Autowired
    com.commission.commission.service.productTypeService productTypeService;

    @PostMapping("/admin/update/commissionPercentage")
    public void updateCommissionPercentage(ProductType producttype)
    {
        productTypeService.updateCommissionPercentage(producttype);
    }
}
