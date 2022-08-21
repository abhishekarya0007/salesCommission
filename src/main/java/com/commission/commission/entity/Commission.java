package com.commission.commission.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int sid;
    Double commission;
    int month;


}
