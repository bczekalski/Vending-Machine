package com.techelevator;

public class Chip extends Product{

    public Chip(String slotLocation, String productName, String price){
        super(slotLocation, productName, price);
    }

    @Override
    public String itemDispensed(){
        return "Crunch Crunch, Yum!";
    }

}
