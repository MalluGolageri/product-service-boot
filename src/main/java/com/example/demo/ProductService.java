package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) {
        return productRepository.findOne(id);
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public void remove(int id) {
        productRepository.delete(id);
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

}
