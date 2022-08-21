package com.commission.commission.Repo;

import com.commission.commission.entity.CommissionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commissionRuleRepo extends JpaRepository<CommissionRule,Integer> {
    CommissionRule findByid(int id);
}
