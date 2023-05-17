package com.tp.biller.repository;

import com.tp.biller.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(long id);
}
