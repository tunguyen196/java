package com.security.services;

import com.security.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getList();
    Product createProduct(Product product);
}
