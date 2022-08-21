package com.commission.commission.controller;


import com.commission.commission.entity.SalesPerson;
import com.commission.commission.service.salesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class salesPersonController {

    @Autowired
    salesPersonService salesPersonService1;


    @PostMapping("/admin/addSalesPerson")
    public SalesPerson addSalesPerson(@RequestBody SalesPerson salesPerson){

        return salesPersonService1.addSalesPerson(salesPerson);

    }

    @GetMapping("/salesPerson/{name}")
    public List<SalesPerson> getSalesPersonByName(@PathVariable String name){

        return salesPersonService1.getSalesPersonByName(name);

    }

    @PostMapping("/check")
    public int checkSalesPerson(@RequestBody SalesPerson salesPerson){

        return salesPersonService1.checkSalesPerson(salesPerson);

    }


    @GetMapping("/admin/{id}")
    public Optional<SalesPerson> getSalesPersonById(@PathVariable int id){

        return salesPersonService1.getSalesPersonById(id);

    }

    @GetMapping("/admin/getAll")
    public List<SalesPerson> getAllSales(){
        return salesPersonService1.getAllSalesPerson();
    }





}
