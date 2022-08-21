package com.commission.commission.Repo;

import com.commission.commission.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productTypeRepo extends JpaRepository<ProductType,Integer> {

//    @Query(value = "Select * from product_type where ")
    List<ProductType> findByPtype(String productType);
}
