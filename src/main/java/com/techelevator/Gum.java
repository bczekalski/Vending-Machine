package com.techelevator;

public class Gum extends Product{

    public Gum(String slotLocation, String productName, String price){
        super(slotLocation, productName, price);
    }

    @Override
    public String itemDispensed(){
        return "Chew Chew, Yum!";
    }

}
