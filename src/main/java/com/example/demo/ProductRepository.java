package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by golagem on 11/3/17.
 */

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public List<Product> findProductByName(String name);
}
