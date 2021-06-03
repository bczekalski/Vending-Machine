package com.techelevator;

public class Candy extends Product{

    public Candy(String slotLocation, String productName, String price){
        super(slotLocation, productName, price);
    }

    @Override
    public String itemDispensed(){
        return "Munch Munch, Yum!";
    }

}
