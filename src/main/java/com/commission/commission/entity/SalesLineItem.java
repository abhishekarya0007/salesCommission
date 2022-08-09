package com.commission.commission.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class SalesLineItem {
    @Id
    @GeneratedValue
    int ID;
    int SID;
    int PID;
    int Amount;
    int Month;
}
