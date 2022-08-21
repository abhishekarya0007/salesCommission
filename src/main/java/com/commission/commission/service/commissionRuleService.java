package com.commission.commission.service;

import com.commission.commission.Repo.commissionRuleRepo;
import com.commission.commission.entity.CommissionRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class commissionRuleService {

    @Autowired
    com.commission.commission.Repo.commissionRuleRepo commissionRuleRepo;
    public void update(CommissionRule commissionRule) {
        Optional<CommissionRule> byId = commissionRuleRepo.findById(commissionRule.getId());
        if(byId.isPresent()) {
            byId.get().setCity_Rule(commissionRule.getCity_Rule());
            byId.get().setState_Rule(commissionRule.getState_Rule());
            byId.get().setCountry_Rule(commissionRule.getCountry_Rule());
        };
    }
}
