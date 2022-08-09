package com.commission.commission.Repo;

import com.commission.commission.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productTypeRepo extends JpaRepository<ProductType,Integer> {
}
