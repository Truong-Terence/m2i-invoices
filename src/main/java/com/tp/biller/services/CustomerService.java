package com.tp.biller.services;

import com.tp.biller.entities.Customer;
import com.tp.biller.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    public Optional<Customer> fetchById(int id){return customerRepository.findById(id);}
    public Customer create(Customer customer){return customerRepository.save(customer);}
    public Optional<Customer> findByPhone(String phone){return customerRepository.findByPhone(phone);}


}
