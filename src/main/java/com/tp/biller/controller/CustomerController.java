package com.tp.biller.controller;

import com.tp.biller.entity.Customer;
import com.tp.biller.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customer-create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-create";
    }

    @PostMapping("/customer-create")
    public String createCustomer(@ModelAttribute("customer") Customer newCustomer) {
        customerService.create(newCustomer);

        return "redirect:/dashboard";
    }
}
