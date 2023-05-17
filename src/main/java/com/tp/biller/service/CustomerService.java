package com.tp.biller.service;

import com.tp.biller.entity.Customer;
import com.tp.biller.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer create(Customer customer){return customerRepository.save(customer);}
    public Optional<Customer> fetchById(Long id){return customerRepository.findById(id);}
}
