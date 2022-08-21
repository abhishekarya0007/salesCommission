package com.commission.commission.service;

import com.commission.commission.Repo.salesPersonRepo;
import com.commission.commission.entity.SalesPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class salesPersonService {

    @Autowired
    salesPersonRepo salesPersonRepo1;

    @Autowired
    private salesPersonService salesPersonService2;


    public SalesPerson addSalesPerson(SalesPerson salesPerson){

        return salesPersonRepo1.save(salesPerson);

    }

    public List<SalesPerson> getSalesPersonByName(String name){

        return salesPersonRepo1.findByname(name);

    }

    public int checkSalesPerson(SalesPerson salesPerson){

        String name = salesPerson.getName();
        List<SalesPerson> s1 =  salesPersonService2.getSalesPersonByName(name);
        int sid = -1;
        for(int i=0;i<s1.size();i++){
            //System.out.println(s1.get(i));
            if(salesPerson.getName().equals(s1.get(i).getName()) && salesPerson.getPassword().equals(s1.get(i).getPassword()))
            {
                return s1.get(i).getSid();

            }else{
                System.out.println("NOOOO");
            }
        }
        return sid;
    }

    public Optional<SalesPerson> getSalesPersonById(int id){

        return salesPersonRepo1.findById(id);

    }

    public List<SalesPerson> getAllSalesPerson(){
        return salesPersonRepo1.findAll();
    }

}
