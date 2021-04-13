package com.lucifers.models;

public class WeightBasedProduct extends Product {
    float pricePerKg;
    float minimumQuantity;

    public WeightBasedProduct(String name, String imageUrl, float pricePerKg, float minimumQuantity) {
        super(name, imageUrl);
        this.pricePerKg = pricePerKg;
        this.minimumQuantity = minimumQuantity;
    }

    @Override
    public String toString() {
        return "WeightBasedProduct{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", pricePerKg=" + pricePerKg +
                ", minimumQuantity=" + minimumQuantity +
                '}';
    }
}
