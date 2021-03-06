package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private Map<Product, String> inventory = new LinkedHashMap<>();
    private File inventoryFile = new File("vendingmachine.csv");

    public Inventory() {
        try (Scanner inputFile = new Scanner(inventoryFile)){
            String item = inputFile.nextLine();
            String[] items = item.split("\\|");
            Chip a1 = new Chip(items[0], items[1], items[2]);
            inventory.put(a1, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Chip a2 = new Chip(items[0], items[1], items[2]);
            inventory.put(a2, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Chip a3 = new Chip(items[0], items[1], items[2]);
            inventory.put(a3, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Chip a4 = new Chip(items[0], items[1], items[2]);
            inventory.put(a4, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Candy b1 = new Candy(items[0], items[1], items[2]);
            inventory.put(b1, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Candy b2 = new Candy(items[0], items[1], items[2]);
            inventory.put(b2, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Candy b3 = new Candy(items[0], items[1], items[2]);
            inventory.put(b3, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Candy b4 = new Candy(items[0], items[1], items[2]);
            inventory.put(b4, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Drink c1 = new Drink(items[0], items[1], items[2]);
            inventory.put(c1, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Drink c2 = new Drink(items[0], items[1], items[2]);
            inventory.put(c2, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Drink c3 = new Drink(items[0], items[1], items[2]);
            inventory.put(c3, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Drink c4 = new Drink(items[0], items[1], items[2]);
            inventory.put(c4, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Gum d1 = new Gum(items[0], items[1], items[2]);
            inventory.put(d1, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Gum d2 = new Gum(items[0], items[1], items[2]);
            inventory.put(d2, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Gum d3 = new Gum(items[0], items[1], items[2]);
            inventory.put(d3, "5");

            item = inputFile.nextLine();
            items = item.split("\\|");
            Gum d4 = new Gum(items[0], items[1], items[2]);
            inventory.put(d4, "5");

        } catch (FileNotFoundException e) {
            System.out.print("You shouldn't be seeing this error, the inventory file was lost!");
        }
    }

    public Map<Product, String> getInventory(){
        return inventory;
    }

    public void setInventory(Map<Product, String> inventory) {
        this.inventory = inventory;
    }

    public String getItemsRemaining(Product product){
        return inventory.get(product);
    }

    public String dispenseItem(Product purchasedProduct) {
        if (inventory.get(purchasedProduct).equals("SOLD OUT")){
            return "This item is sold out, please try another item.";
        }else if (inventory.get(purchasedProduct).equals("1")){
            this.inventory.put(purchasedProduct, "SOLD OUT");
        }else {
            this.inventory.put(purchasedProduct, String.valueOf(Integer.parseInt(inventory.get(purchasedProduct)) - 1));
        }
        return purchasedProduct.itemDispensed();
    }

    public String toString(){
        String output = "\n###################################################\nSLOT|        NAME         | PRICE |     QUANTITY\n";
        for (Product product : inventory.keySet()){
            String productNameFiller = "                    ";
            String productNameFilled = product.getProductName() + productNameFiller.substring(0, productNameFiller.length() - product.getProductName().length());
            String formattedPrice = String.format("%.02f", product.getPrice());
            String quantity;
            if (getItemsRemaining(product).equals("SOLD OUT")){
                quantity = "SOLD OUT";
            }else{
                quantity = getItemsRemaining(product) + " left in stock.";
            }
            output+= "  " + product.getSlotLocation() + "| " + productNameFilled + "| $" + formattedPrice + " | " + quantity + "\n";
        }
        output+= "###################################################\n";
        return output;
    }

    public boolean isSoldOut(Product product){
        if (inventory.get(product).equals("SOLD OUT")){
            return true;
        }
        return false;
    }

    public boolean itemExists(String userSaid){
        for (Product product : inventory.keySet()){
            if (product.getSlotLocation().equals(userSaid)){
                return true;
            }
        }
        return false;
    }

    public Product getStringToProduct(String input){
        for (Product product : inventory.keySet()){
            if (product.getSlotLocation().equals(input)){
                return product;
            }
        }
        return null;
    }
}
