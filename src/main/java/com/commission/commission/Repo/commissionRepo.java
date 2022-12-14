package com.commission.commission.Repo;

import com.commission.commission.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commissionRepo extends JpaRepository<Commission,Integer> {
    Commission findBySid(int sid);

    Commission findByMonth(int month);

    Commission findBySidAndMonth(int sid, int month);
}
