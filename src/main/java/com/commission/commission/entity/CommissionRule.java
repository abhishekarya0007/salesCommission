package com.commission.commission.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class  CommissionRule {
    @Id
    int id;
    Double city_Rule;
    Double state_Rule;
    Double country_Rule;
}
