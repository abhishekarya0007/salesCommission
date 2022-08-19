package com.commission.commission.service;

import com.commission.commission.Repo.*;
import com.commission.commission.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    com.commission.commission.Repo.salesPersonRepo salesPersonRepo;


    @Autowired
    commissionRuleRepo commissionRuleRepo;
    public Double commission(int sid, int month)
    {

        List<SalesLineItem> sales = salesLineItemService.salesByMonth(sid, month);
        Double totalCommission= 0.0;
        Double old_commission=0.0;
        for (int x=0;x<sales.size();x++)
        {
            int pid = sales.get(x).getPID();
            String productType = (productRepo.findById(pid)).get().getProductType();
            List<ProductType> productTypeList = productTypeRepo.findByPType(productType);
            for (int y=0;y<productTypeList.size();y++)
            {
                if(sales.get(x).getAmount()<=productTypeList.get(y).getPrice())
                {
                    totalCommission=totalCommission+(productTypeList.get(y).getCommission()*sales.get(x).getAmount());
                        break;
                }
            }
        }
        System.out.println("Total"+totalCommission);
        if(commissionRepo.findBySIDAndMonth(sid,month)!=null)
        {
             old_commission = commissionRepo.findBySIDAndMonth(sid, month).getCommission();
             System.out.println("Old"+old_commission);
             Commission dummy = commissionRepo.findBySIDAndMonth(sid,month);
             dummy.setCommission(totalCommission);
             commissionRepo.save(dummy);
        }
        else {
            Commission commission = new Commission();
            commission.setSID(sid);
            commission.setMonth(month);
            commission.setCommission(totalCommission);
            commissionRepo.save(commission);
        }
        Optional<SalesPerson> byId = salesPersonRepo.findById(sid);
        //System.out.println(byId.get().getCityID());
        if(byId.get().getCityID()!=0)
        {
            if(commissionRepo.findBySIDAndMonth(byId.get().getCityID(),month)!=null)
            {
                Commission dummy = commissionRepo.findBySIDAndMonth(byId.get().getCityID(), month);
                dummy.setCommission((totalCommission*commissionRuleRepo.findById(1).get().getCity_Rule())+(commissionRepo.findBySIDAndMonth(byId.get().getCityID(), month).getCommission())-(old_commission*commissionRuleRepo.findById(1).get().getCity_Rule()));
                commissionRepo.save(dummy);
            }
            else
            {
                Commission cityCommission = new Commission();
                cityCommission.setSID(byId.get().getCityID());
                cityCommission.setMonth(month);
                cityCommission.setCommission(totalCommission*commissionRuleRepo.findById(1).get().getCity_Rule());
                commissionRepo.save(cityCommission);
            }
//            System.out.println(commission.getCommission()+"  -----  "+commission.getSID());
        }
        if(byId.get().getStateID()!=0)
        {
            if(commissionRepo.findBySIDAndMonth(byId.get().getStateID(),month)!=null)
            {
                Commission dummy = commissionRepo.findBySIDAndMonth(byId.get().getStateID(), month);
                dummy.setCommission((totalCommission*commissionRuleRepo.findById(1).get().getState_Rule())+(commissionRepo.findBySIDAndMonth(byId.get().getStateID(), month).getCommission())-(old_commission*commissionRuleRepo.findById(1).get().getState_Rule()));
                commissionRepo.save(dummy);
            }
            else
            {
                Commission stateCommission = new Commission();
                stateCommission.setSID(byId.get().getStateID());
                stateCommission.setMonth(month);
                stateCommission.setCommission(totalCommission*commissionRuleRepo.findById(1).get().getState_Rule());
                commissionRepo.save(stateCommission);
            }
//            System.out.println(commission.getCommission()+"  -----  "+commission.getSID());
        }
        if(byId.get().getCountryID()!=0)
        {
            if(commissionRepo.findBySIDAndMonth(byId.get().getCountryID(),month)!=null)
            {
                Commission dummy = commissionRepo.findBySIDAndMonth(byId.get().getCountryID(), month);
                dummy.setCommission((totalCommission*commissionRuleRepo.findById(1).get().getCountry_Rule())+(commissionRepo.findBySIDAndMonth(byId.get().getCountryID(), month).getCommission())-(old_commission*commissionRuleRepo.findById(1).get().getCountry_Rule()));
                commissionRepo.save(dummy);
            }
            else
            {
                Commission countryCommission = new Commission();
                countryCommission.setSID(byId.get().getCountryID());
                countryCommission.setMonth(month);
                countryCommission.setCommission(totalCommission*commissionRuleRepo.findById(1).get().getCountry_Rule());
                commissionRepo.save(countryCommission);
            }
//            System.out.println(commission.getCommission()+"  -----  "+commission.getSID());
        }
        return totalCommission;
    }
}
