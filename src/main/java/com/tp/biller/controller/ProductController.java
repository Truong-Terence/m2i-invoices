package com.tp.biller.controller;

import com.tp.biller.entity.Product;
import com.tp.biller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product-create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(@ModelAttribute("product") Product newProduct) {
        productService.create(newProduct);
        return "redirect:/dashboard";
    }
}
