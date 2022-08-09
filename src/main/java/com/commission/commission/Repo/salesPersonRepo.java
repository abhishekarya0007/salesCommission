package com.commission.commission.Repo;


import com.commission.commission.entity.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface salesPersonRepo extends JpaRepository<SalesPerson,Integer> {
}
