package com.commission.commission.controller;

import com.commission.commission.entity.CommissionRule;
import com.commission.commission.service.commissionRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class commissionRuleController {
    @Autowired
    com.commission.commission.service.commissionRuleService commissionRuleService;

    @PostMapping("admin/update/commissionRule")
    public void update(CommissionRule commissionRule)
    {
        commissionRuleService.update(commissionRule);
    }
}
