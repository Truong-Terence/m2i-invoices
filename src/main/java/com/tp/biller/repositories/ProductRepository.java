package com.tp.biller.repositories;

import com.tp.biller.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
