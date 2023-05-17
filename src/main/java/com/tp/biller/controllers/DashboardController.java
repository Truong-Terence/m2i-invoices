package com.tp.biller.controllers;

import com.tp.biller.entities.Bill;
import com.tp.biller.entities.Customer;
import com.tp.biller.entities.Product;
import com.tp.biller.repositories.BillRepository;
import com.tp.biller.repositories.CustomerRepository;
import com.tp.biller.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
