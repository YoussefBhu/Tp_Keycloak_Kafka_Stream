package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private Date date ;
    @Transient @OneToMany(mappedBy = "bill",fetch = FetchType.EAGER)
    private List<ProductItem> ProductItems = new ArrayList<ProductItem>();
    @Transient
    private Customer customer ;
    private long customerId ;
}