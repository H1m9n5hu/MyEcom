package Assignment_2.models;
public class CartItem {

    String name;
    float unitPrice, quantity;

    public CartItem(String name, float unitPrice, float quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    float cost() {
        return unitPrice*quantity;
    }

    @Override
    public String toString() {
        return "\n " + name + String.format(" ( cost = %f X %f = %f", unitPrice, quantity, cost()) + " )";
    }
}
