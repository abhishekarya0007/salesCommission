package com.commission.commission.service;

import com.commission.commission.Repo.commissionRuleRepo;
import com.commission.commission.entity.CommissionRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class commissionRuleService {

    @Autowired
    com.commission.commission.Repo.commissionRuleRepo commissionRuleRepo;
    public List<CommissionRule> update(CommissionRule commissionRule) {
        CommissionRule dummy = commissionRuleRepo.findByid(1);
        if(dummy!=null)
        {
            dummy.setCity_Rule(commissionRule.getCity_Rule());
            dummy.setState_Rule(commissionRule.getState_Rule());
            dummy.setCountry_Rule(commissionRule.getCountry_Rule());
            System.out.println(dummy);
            commissionRuleRepo.save(dummy);
        }
            else
        {
            commissionRuleRepo.save(commissionRule);
        }
            return commissionRuleRepo.findAll();
    }
}
