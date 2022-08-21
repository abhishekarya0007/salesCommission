package com.commission.commission.service;

import com.commission.commission.entity.SalesLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class salesLineItemService {

    @Autowired
    com.commission.commission.Repo.salesLineItemRepo salesLineItemRepo;
    public List<SalesLineItem> salesByMonth(int sid, int month) {
        List<SalesLineItem> byId = salesLineItemRepo.findAllBySid(sid);
        ArrayList<SalesLineItem> f = new ArrayList<>();
        System.out.println(byId);
           for(int x=0;x<byId.size();x++) {
               if (byId.get(x).getMonth() == month) {
                   f.add(byId.get(x));
               }
           }
       return f;
    }

    public SalesLineItem addSalesLineItem(SalesLineItem salesLineItem){

        return salesLineItemRepo.save(salesLineItem);

    }
}
