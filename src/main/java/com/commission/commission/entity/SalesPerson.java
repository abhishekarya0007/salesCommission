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
    int SID;
    String Name;
    String Password;
    @Column(nullable = true)
    int CityID;
    @Column(nullable = true)
    int StateID;
    @Column(nullable = true)
    int CountryID;
}
