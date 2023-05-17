package com.tp.biller.controllers;

import com.tp.biller.entities.Customer;
import com.tp.biller.repositories.CustomerRepository;
import com.tp.biller.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
//        model.addAttribute("customer", new Customer());
        return "customer-create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer newCustomer) {
        Customer addedCustomer = customerService.create(newCustomer);
//        Customer addedCustomer = customerService.create(newCustomer);
//        int addedCustomerId = Math.toIntExact(addedCustomer.getId());
//        Optional<Customer> customerOptional = customerService.fetchById(addedCustomerId);
//        customerService.save(customer);
        return "redirect:/dashboard";
    }
}

