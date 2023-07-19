package com.tpe.app;

import com.tpe.MyAppConfiguration;
import com.tpe.domain.Product;
import com.tpe.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        // Initialize the Spring container
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfiguration.class);

        // Get the ProductService bean from the Spring container
        ProductService productService = context.getBean(ProductService.class);


        // Test the ProductService
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Sample Product");
        product1.setPrice(19.99);

        //add product
        productService.addProduct(product1);

        //find product
        productService.getProductById(1L);

        //delete product
        productService.deleteProductById(2L);

        // Close the Spring container


        System.out.println("-------------------------------------");

        MyComponent myComponent = context.getBean(MyComponent.class);
        System.out.println( myComponent.getUsername());
        System.out.println(myComponent.getPassword());
        System.out.println(myComponent.getDatabaseUrl());
        System.out.println("==========================");
        System.out.println(myComponent.getCode());
        System.out.println(myComponent.getWebsite());


        System.out.println("----------------------------------");

        MyComponent2 myComponent2 = context.getBean(MyComponent2.class);
        System.out.println(myComponent2.getUsername());
        System.out.println(myComponent2.getPassword());
        System.out.println(myComponent2.getDatabaseUrl());
        System.out.println("==========================");
        System.out.println(myComponent2.getCode());
        System.out.println(myComponent2.getWebsite());



        System.out.println("--------------------------------");

        MyComponent3 myComponent3= context.getBean(MyComponent3.class);
        myComponent3.DisplayProperties();




        context.close();
    }
}
