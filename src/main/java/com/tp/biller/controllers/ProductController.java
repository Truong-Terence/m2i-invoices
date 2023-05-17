package com.tp.biller.controllers;

import com.tp.biller.entities.Product;
import com.tp.biller.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/dashboard";
    }
}
