package com.lucifers.models;

import java.util.List;

public class Product {

    //Common in Both Weight Based Product and Variant Based Product
    public String name, imageUrl;
    public int type;

    //Fields of Weight Based Products
    public float pricePerKg, minimumQuantity;

    //Details of Variant Based Products
    public List<Variant> variants;

    //Constructor for Weight Based Product
    public Product(String name, String imageUrl, float pricePerKg, float minimumQuantity) {
        type = ProductType.TYPE_WBP;
        this.name = name;
        this.imageUrl = imageUrl;
        this.pricePerKg = pricePerKg;
        this.minimumQuantity = minimumQuantity;
    }

    //Constructor for Variant Based Product
    public Product(String name, String imageUrl, List<Variant> variants) {
        type = ProductType.TYPE_VBP;
        this.name = name;
        this.imageUrl = imageUrl;
        this.variants = variants;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(type == ProductType.TYPE_WBP)
            builder.append("Weight Based { ");
        else
            builder.append("Variant Based { ");

        builder.append("Name = ").append(name);

        if(type == ProductType.TYPE_WBP) {
            builder.append(", Minimum Quantity = ").append(minimumQuantity);
            builder.append(", Price Per Kg = ").append(pricePerKg);
        }
        else {
//            builder.append(", Variant Based { ");
            builder.append(", Variants = ").append(variants);
        }

        builder.append(" } ");

        return builder.toString();
    }

}
