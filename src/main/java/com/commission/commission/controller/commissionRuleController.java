package com.commission.commission.controller;

import com.commission.commission.entity.CommissionRule;
import com.commission.commission.service.commissionRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class commissionRuleController {
    @Autowired
    com.commission.commission.service.commissionRuleService commissionRuleService;

    @PostMapping("admin/update/commissionRule")
    public List<CommissionRule> update(@RequestBody CommissionRule commissionRule)
    {
        return commissionRuleService.update(commissionRule);
    }
}
