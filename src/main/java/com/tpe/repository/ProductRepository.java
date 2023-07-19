package com.tpe.repository;

import com.tpe.domain.Product;

public interface ProductRepository {
    Product findById(Long id);
    void save(Product product);
    void delete(Long id);
}
