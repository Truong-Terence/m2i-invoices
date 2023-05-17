package com.tp.biller.controller;

import com.tp.biller.entity.Customer;
import com.tp.biller.entity.Product;
import com.tp.biller.repository.BillRepository;
import com.tp.biller.repository.CustomerRepository;
import com.tp.biller.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BillRepository billRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Customer> customers = customerRepository.findAll();
        List<Product> products = productRepository.findAll();

        model.addAttribute("customers", customers);
        model.addAttribute("products", products);
        return "dashboard";
    }

}
