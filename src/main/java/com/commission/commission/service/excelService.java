package com.commission.commission.service;


import com.commission.commission.Repo.salesLineItemRepo;
import com.commission.commission.entity.SalesLineItem;
import com.commission.commission.helper.myExcelHelper;
import lombok.experimental.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class excelService {

    @Autowired
    private salesLineItemRepo salesLineItemRepo;
    public void save(MultipartFile file)
    {
        try {
            List<SalesLineItem> salesLineItems = myExcelHelper.convertExcelToListofSalesLineItem(file.getInputStream());
            this.salesLineItemRepo.saveAll(salesLineItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<SalesLineItem> getAllSalesLineItems(){
            return this.salesLineItemRepo.findAll();
    }


}
