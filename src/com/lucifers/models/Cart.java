package com.lucifers.models;

import java.util.HashMap;

public class Cart {

    HashMap<String, CartItem> cartItems = new HashMap<>();
    float total;
    int noOfItems;

    //Function for adding Weight Based Products
    public void add(Product product, float quantity) {

        //If Item is already exist in Cart
        if(cartItems.containsKey(product.name)) {
            total -= cartItems.get(product.name).cost();
            cartItems.get(product.name).quantity = quantity;
        }

        //Adding for the first time
        else {
            CartItem item = new CartItem(product.name, product.pricePerKg, quantity);
            cartItems.put(product.name, item);
            noOfItems++;
        }

        //Update Cart Summary
        total += product.pricePerKg*quantity;

    }

    //Function for adding Variant Based Products
    public void add(Product product, Variant variant) {

        String key = product.name + " " + variant.name;

        //If Item is already exist in Cart
        if(cartItems.containsKey(key)) {
            cartItems.get(key).quantity++;
        }

        //Adding for the first time
        else {
            CartItem item = new CartItem(product.name, variant.price, 1);
            cartItems.put(key, item);
        }

        //Update Cart Summary
        noOfItems++;
        total += variant.price;
    }

    //Function for removing Products
    public void remove(Product product) {
        if(product.type == ProductType.TYPE_WBP)
            removeWBP(product);
        else
            removeAllVBP(product);
    }

    //Function for removing Weight Based Products
    private void removeWBP(Product product) {
        total -= cartItems.get(product.name).cost();
        noOfItems--;
        cartItems.remove(product.name);
    }

    //Function for removing all Variant Based Products
    public void removeAllVBP(Product product) {
        for(Variant variant : product.variants) {
            String key = product.name + " " + variant.name;
            if(cartItems.containsKey(key)) {
                total -= cartItems.get(key).cost();
                noOfItems -= cartItems.get(key).quantity;
                cartItems.remove(key);
            }
        }
    }

    //Function for decrement the Quantity of Variant Based Products
    public void decrement(Product product, Variant variant) {

            String key = product.name + " " + variant.name;

            //Update Cart Quantity
            cartItems.get(key).quantity--;

            //Update Cart Summary
            total -= variant.price;
            noOfItems--;

            //Remove a function when if quantity = 0
            if(cartItems.get(key).quantity == 0)
                cartItems.remove(key);

    }

    @Override
    public String toString() {
        return cartItems.values() + String.format("\nTotal Cost is %.2f,\nTotal number of items is %d.",total,noOfItems);
    }
}
