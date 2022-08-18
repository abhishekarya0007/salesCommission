package com.commission.commission.service;

import com.commission.commission.Repo.commissionRepo;
import com.commission.commission.Repo.productRepo;
import com.commission.commission.Repo.productTypeRepo;
import com.commission.commission.entity.Commission;
import com.commission.commission.entity.ProductType;
import com.commission.commission.entity.SalesLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commissionService {
    @Autowired
    salesLineItemService salesLineItemService;
    @Autowired
    productRepo productRepo;
    @Autowired
    productTypeRepo productTypeRepo;
    @Autowired
    com.commission.commission.Repo.commissionRepo commissionRepo;
    public Double commission(int sid, int month)
    {
        List<SalesLineItem> sales = salesLineItemService.salesByMonth(sid, month);
        Double totalCommission= 0.0;
        for (int x=0;x<sales.size();x++)
        {
            int pid = sales.get(x).getPID();
            String productType = (productRepo.findById(pid)).get().getProductType();
            List<ProductType> productTypeList = productTypeRepo.findByPType(productType);
            for (int y=0;y<productTypeList.size();y++)
            {
                if(sales.get(x).getAmount()<=productTypeList.get(x).getPrice())
                {
                    totalCommission=totalCommission+(productTypeList.get(x).getCommission()*sales.get(x).getAmount());
                        break;
                }
            }
        }
            Commission commission = new Commission();
            commission.setSID(sid);
            commission.setMonth(month);
            commission.setCommission(totalCommission);
            commissionRepo.save(commission);
            return totalCommission;
    }
}
