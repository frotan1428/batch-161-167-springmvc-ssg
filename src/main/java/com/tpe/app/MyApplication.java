package com.tpe.app;

import com.tpe.MyAppConfiguration;
import com.tpe.domain.Product;
import com.tpe.service.ProductService;
import com.tpe.shop.prototypeSingleton.ShoppingCart;
import com.tpe.shop.prototypeSingleton.ShoppingCartUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        // Initialize the Spring container
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfiguration.class);

        // Get the ProductService bean from the Spring container
        ProductService productService = context.getBean(ProductService.class);


        /*

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

         */

        ShoppingCartUser cartUser1= context.getBean(ShoppingCartUser.class);
        ShoppingCartUser cartUser2= context.getBean(ShoppingCartUser.class);
        System.out.println(cartUser1);
        System.out.println(cartUser2);

        ShoppingCart shoppingCart= context.getBean(ShoppingCart.class);
        ShoppingCart shoppingCar2= context.getBean(ShoppingCart.class);

        if (shoppingCart==shoppingCar2){
            System.out.println("This is a singleton scope :    ");
        }else {
            System.out.println("This is a prototype scope :    ");
        }
        shoppingCart.addItem("Item");
        System.out.println(shoppingCart.getItems());

        if (cartUser1==cartUser2){
            System.out.println("This is a singleton scope :    ");
        }else {
            System.out.println("This is a prototype scope :    ");
        }

        //add item to shopping carts fo both user

        cartUser1.addItemToCart("Item 1");
        cartUser1.addItemToCart("Item 2");


        cartUser2.addItemToCart("Item 3");
        cartUser2.addItemToCart("Item 4");

        System.out.println("Items in ShoppingCartUser 1 :  ");
        System.out.println(cartUser1.getCartItems());

        System.out.println("Items in ShoppingCartUser 2 :  ");
        System.out.println(cartUser2.getCartItems());



        context.close();
    }
}
