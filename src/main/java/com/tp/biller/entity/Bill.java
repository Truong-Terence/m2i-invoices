package com.tp.biller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bill")
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
    @JoinColumn(name = "id_customer")
    private Customer customer;
    @OneToMany
    @JoinTable(name = "bill_products",
            joinColumns = @JoinColumn(name = "id_bill"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;

}
