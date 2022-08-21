package com.commission.commission.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SalesPerson {
    @Id
    int sid;
    String name;
    String password;
    @Column(nullable = true)
    int cityID;
    @Column(nullable = true)
    int stateID;
    @Column(nullable = true)
    int countryID;
}
