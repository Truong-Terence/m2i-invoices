package com.tp.biller.repositories;

import com.tp.biller.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByPhone(String phone);
}
