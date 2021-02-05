package com.example.demo.Entities;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Facture {
    @Id
    private long id ;
    private String name ;
    private double montant ;
}
