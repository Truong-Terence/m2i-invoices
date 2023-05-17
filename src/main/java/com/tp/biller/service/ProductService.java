package com.tp.biller.service;

import com.tp.biller.entity.Product;
import com.tp.biller.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product create(Product product){return productRepository.save(product);}
    public Optional<Product> fetchById(Long id){return productRepository.findById(id);}
}
