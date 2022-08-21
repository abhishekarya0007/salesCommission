package com.commission.commission.controller;


import com.commission.commission.entity.Commission;
import com.commission.commission.service.commissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class commissionController {

    @Autowired
    commissionService commissionService;
    @PostMapping("/admin/calculateCommission")
    public ResponseEntity<Double> commission(@RequestBody Commission commission)
    {
        int sid= commission.getSid();
        int month = commission.getMonth();
        Double newcommission = commissionService.commission(sid, month);
        return new ResponseEntity<>(newcommission, HttpStatus.OK);
    }
}
