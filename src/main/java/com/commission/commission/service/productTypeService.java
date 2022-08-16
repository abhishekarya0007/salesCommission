package com.commission.commission.service;

import com.commission.commission.Repo.productTypeRepo;
import com.commission.commission.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class productTypeService {

    @Autowired
    com.commission.commission.Repo.productTypeRepo productTypeRepo;
    public void updateCommissionPercentage(ProductType productType) {

        Optional<ProductType> byId = productTypeRepo.findById(productType.getId());
        if(byId.isPresent())
        {
            byId.get().setCommission(productType.getCommission());
        }
    }
}
