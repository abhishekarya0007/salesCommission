package com.commission.commission.Repo;


import com.commission.commission.entity.SalesLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface salesLineItemRepo extends JpaRepository<SalesLineItem,Integer> {

    List<SalesLineItem> findAllBySID(int sid);
}
