package com.tp.biller.repository;

import com.tp.biller.entity.Customer;
import com.tp.biller.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
}
