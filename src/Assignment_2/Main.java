package Assignment_2;

import Assignment_2.models.Cart;
import Assignment_2.models.Product;
import Assignment_2.models.Variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //Create Products
        Product papaya = new Product("Papaya","image",50,2.5f),
                orange = new Product("Orange", "image", 30, 5f),
                kiwi =new Product("Kiwi","image",new ArrayList<>(
                        Arrays.asList(
                                new Variant("1kg",100),
                                new Variant("500g",60)
                        )
                )),
                bakingSoda = new Product("Baking Soda", "image",new ArrayList<>(
                        Collections.singletonList(new Variant("250g", 75))
                ));

        Cart cart = new Cart();
        cart.add(papaya,5f);
        cart.add(orange,2.5f);
        cart.add(kiwi,kiwi.variants.get(1));
        cart.add(kiwi,kiwi.variants.get(0));
        cart.add(kiwi,kiwi.variants.get(1));
        cart.add(bakingSoda,bakingSoda.variants.get(0));
        cart.add(bakingSoda,bakingSoda.variants.get(0));
        System.out.println(cart);

        cart.remove(papaya);
        cart.decrement(kiwi,kiwi.variants.get(1));
        cart.decrement(bakingSoda,bakingSoda.variants.get(0));
        cart.decrement(bakingSoda,bakingSoda.variants.get(0));
        System.out.println(cart);

    }
}
