package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Facture {
    private long id ;
    private String name ;
    private double montant ;
}
