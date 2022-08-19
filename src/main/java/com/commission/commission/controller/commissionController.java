package com.commission.commission.controller;


import com.commission.commission.service.commissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class commissionController {

    @Autowired
    commissionService commissionService;
    @GetMapping("/admin/calculateCommission")
    public ResponseEntity<Double> commission(@RequestParam("SID") int SID, @RequestParam("Month") int Month)
    {
        Double commission = commissionService.commission(SID, Month);
        return new ResponseEntity<>(commission, HttpStatus.OK);
    }
}