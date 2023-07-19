package com.tpe.service;

import com.tpe.domain.Product;
import com.tpe.repository.ProductRepository;
import com.tpe.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

     /*
        There 3  types of injection :
        1-Constructor Injection: Dependency injection through a class constructor.
        2-Setter Injection: Dependency injection through setter methods.
        3-Field Injection: Dependency injection directly into class fields.
     */


/*
    // 1-Constructor Injection:
    @Autowired()
    private  ProductRepository productRepository;
    public ProductServiceImpl(@Qualifier("consumeRepository")ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 2-Setter Injection:
    @Autowired
    @Qualifier("consumeRepository")
    private ProductRepository productRepository;
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


 */
    @Autowired
    private ProductRepository productRepository;

        @Override
        public Product getProductById(Long id) {
            Product product = productRepository.findById(id);
            if (product == null) {
                throw new ProductNotFoundException("Product with ID " + id + " not found.");
            }else {
                System.out.println("Product with ID : "+ id);
            }
            return product;
        }

    @Override
    public void addProduct(Product product) {
        System.out.println("product added successfully ");
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {

        if (productRepository.findById(id) == null) {
            System.out.println("Product with ID " + id + " not found. Cannot delete.");
        }else {
            System.out.println("Product with Id :" + id + " successfully deleted .");
        }
        productRepository.delete(id);
    }
}
