package com.techelevator;

public class Product implements Dispensable {
    private String slotLocation;
    private String productName;
    private double price;
    public Product(String slotLocation, String productName, String price){
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = Double.parseDouble(price);
    }

    public double getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public String itemDispensed(){
        return "You should not be seeing this! If you do there is an error! (Product.itemDispensed() was called)";
    }

}
