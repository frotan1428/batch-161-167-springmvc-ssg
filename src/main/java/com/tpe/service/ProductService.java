package com.tpe.service;

import com.tpe.domain.Product;

public interface ProductService {
    Product getProductById(Long id);
    void addProduct(Product product);
    void deleteProductById(Long id);
}
