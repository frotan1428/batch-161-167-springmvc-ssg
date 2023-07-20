package com.tpe.shop.prototypeSingleton;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Scope("singleton") // this is active by defaults
//@Scope("prototype")
public class ShoppingCartUser {
    @Autowired
    private ShoppingCart cart;
    public ShoppingCartUser(ShoppingCart cart) {
        this.cart = cart;
    }
    public  void addItemToCart(String item){

        cart.addItem(item);
    }
    public List<String> getCartItems(){
        return cart.getItems();
    }



}
