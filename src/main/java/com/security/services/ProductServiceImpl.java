package com.security.services;

import com.security.models.Product;
import com.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }
}
