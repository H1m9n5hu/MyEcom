package Assignment_1.models;

import java.util.HashMap;

public class Cart {

    HashMap<String, CartItem> cartItems = new HashMap<>();
    float total;
    int noOfItems;

    //Function for adding Weight Based Products
    public void add(Product product, float quantity) {
        CartItem item = new CartItem(product.name, product.pricePerKg, quantity);
        cartItems.put(product.name, item);
        noOfItems++;

        //Update Cart Summary
        total += product.pricePerKg*quantity;

    }

    //Function for edit to Weight Based Products
    public void edit(String str, float pricePerKg, float quantity) {
        total -= cartItems.get(str).cost();
        cartItems.get(str).unitPrice = pricePerKg;
        cartItems.get(str).quantity = quantity;

        //Update Cart Summary
        total += cartItems.get(str).unitPrice*quantity;
    }

    //Function for adding Variant Based Products
    public void add(Product product, Variant variant) {

        String key = product.name + " " + variant.name;

        if(!cartItems.containsKey(key)) {
            CartItem item = new CartItem(product.name, variant.price, 1);
            cartItems.put(key, item);
            noOfItems++;
            total += variant.price;
        }

    }

    //Function to edit Variant Based Product
    public void edit(String key) {
        if(cartItems.containsKey(key)) {
            cartItems.get(key).quantity++;
            noOfItems++;
            total += cartItems.get(key).unitPrice;
        }
    }

    //Function for removing Weight Based Products
    public void removeWBP(String key) {
        if(cartItems.containsKey(key)) {
            total -= cartItems.get(key).cost();
            noOfItems--;
            cartItems.remove(key);
        }
    }

    //Function for removing all Products of a Particular Variant
    public void removeVBP(String key) {
        if(cartItems.containsKey(key)) {
            total -= cartItems.get(key).cost();
            noOfItems -= cartItems.get(key).quantity;
            cartItems.remove(key);
        }
    }

    //Function for decrement the Quantity of Variant Based Products
    public void decrement(String key) {

        //Update Cart Quantity
        cartItems.get(key).quantity--;

        //Update Cart Summary
        total -= cartItems.get(key).unitPrice;
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
