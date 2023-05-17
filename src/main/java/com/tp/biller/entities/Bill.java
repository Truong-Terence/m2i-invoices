package com.tp.biller.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date billig_date;
    @Temporal(TemporalType.DATE)
    private Date due_date;
    private String payment;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY)
    private Collection<Product> products;

}
