package Assignment_3;

import Assignment_3.models.Product;
import Assignment_3.models.Variant;
import Assignment_3.models.VariantBasedProduct;
import Assignment_3.models.WeightBasedProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Create Products
        Product papaya = new WeightBasedProduct("Papaya","image",50f,2.5f);
        Product bakingSoda = new VariantBasedProduct("Baking Soda","image",new ArrayList<>(
                Arrays.asList(
                        new Variant("400g",230),
                        new Variant("2.5g",199)
                )
        ));

        //Print these products one by one...
        System.out.println(papaya);
        System.out.println(bakingSoda);

        //Add these products in List
        List<Product> products = new ArrayList<>(
                Arrays.asList(
                        new WeightBasedProduct("Apple","image",80f,2.5f),
                        new VariantBasedProduct("Kiwi","image",new ArrayList<>(
                                Arrays.asList(new Variant("3kg",90),
                                        new Variant("1kg",50)
                                )
                        ))
                )
        );

        //Print all products in a single list...
        System.out.println(products);

    }
}
