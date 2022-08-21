package com.commission.commission.service;

import com.commission.commission.Repo.productTypeRepo;
import com.commission.commission.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productTypeService {

    @Autowired
    com.commission.commission.Repo.productTypeRepo productTypeRepo;
    public List<ProductType> updateCommissionPercentage(ProductType productType) {

        ProductType dummy = productTypeRepo.findByid(productType.getId());
        if(dummy!=null)
        {
            dummy.setCommission(productType.getCommission());
            dummy.setPrice(productType.getPrice());
            dummy.setPtype(productType.getPtype());
            productTypeRepo.save(dummy);
        }
        else
        {
            productTypeRepo.save(productType);
        }
            return productTypeRepo.findAll();
    }
}
