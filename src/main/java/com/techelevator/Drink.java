package com.techelevator;

public class Drink extends Product{

    public Drink(String slotLocation, String productName, String price){
        super(slotLocation, productName, price);
    }

    @Override
    public String itemDispensed(){
        return "Glug Glug, Yum!";
    }

}
