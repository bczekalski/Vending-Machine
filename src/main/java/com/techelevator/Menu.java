package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    private final Scanner in;
    private final Inventory stock;
    private final Balance machineBalance;

    public Menu(Scanner in, Inventory stock, Balance machineBalance){
        this.in = in;
        this.stock = stock;
        this.machineBalance = machineBalance;
    }

    public void mainMenu(){
        System.out.println("###################################################\n########## WELCOME TO THE VENDO-MATIC-800 #########\n###################################################");
        while(true) {
            // Display the main menu
            System.out.println("\n#################### MAIN MENU ####################");
            System.out.print(
                    "\n(1) Display Vending Machine Items" +
                            "\n(2) Purchase" +
                            "\n(3) Exit" +
                            "\n\nPlease choose an option >>> ");
            String choice = in.nextLine();
            if (choice.equals("1")) {
                // Display inventory
                System.out.print(stock);
            } else if (choice.equals("2")) {
                // Go to purchase menu
                purchaseMenu();
            } else if (choice.equals("3")) {
                System.exit(1);
            } else {
                System.out.println("\nThat was not a valid option.\n");
            }
        }
    }

    private void purchaseMenu() {
        boolean purchaseWindowOpen = true;
        while (purchaseWindowOpen) {
            System.out.println("\n################## PURCHASE MENU ##################");
            System.out.print(
                    "\n(1) Feed Money" +
                            "\n(2) Select Product" +
                            "\n(3) Finish Transaction" +
                            "\n\nCurrent Money Provided: $" + machineBalance.getBalance() +
                            "\n\nPlease choose an option >>> ");
            String purchaseChoice = in.nextLine();
            if (purchaseChoice.equals("1")) {
                // Feed Money code
                feedMoneyMenu();
            } else if (purchaseChoice.equals("2")) {
                // Select Product code
                System.out.print(stock);
                System.out.print("Please choose a slot option (i.e. A3) >>> ");
                String productChoice = in.nextLine().toUpperCase();
                boolean validProductChoice = stock.itemExists(productChoice);
                if (validProductChoice) {
                    System.out.println("You have selected: " + productChoice);
                    Product productToDispense = stock.getStringToProduct(productChoice);
                    if (stock.isSoldOut(productToDispense)) {
                        System.out.println("Sorry, that product is sold out!");
                    } else if (machineBalance.getBalance().compareTo(BigDecimal.valueOf(productToDispense.getPrice())) >= 0) {
                        machineBalance.addToLogProduct(productToDispense);
                        System.out.println("Now dispensing " + productToDispense.getProductName() + "\nwhich costs $" + productToDispense.getPrice());
                        System.out.println(stock.dispenseItem(productToDispense));
                        System.out.println("Money Remaining: $" + machineBalance.getBalance());
                    } else {
                        System.out.println("Please add additional money using the Feed Money\noption to purchase this product.");
                    }
                } else {
                    System.out.println("That was not a valid product code, returning to\nthe purchase menu...");
                }
            } else if (purchaseChoice.equals("3")) {
                // Finish Transaction code
                machineBalance.addToLogGiveChange();
                purchaseWindowOpen = false;
            } else {
                System.out.println("\nThat was not a valid option.\n");
            }
        }
    }

    private void feedMoneyMenu() {
        boolean feedMoneyMenuOpen = true;
        while (feedMoneyMenuOpen) {
            System.out.println("\n################# FEED MONEY MENU #################");
            System.out.print(
                    "\n(1)  insert $1.00" +
                            "\n(2)  insert $2.00" +
                            "\n(5)  insert $5.00" +
                            "\n(10) insert $10.00" +
                            "\n(0)  Done adding money" +
                            "\n\nCurrent Money Provided: $" + machineBalance.getBalance() +
                            "\n\nPlease choose an option >>> ");
            String moneyChoice = in.nextLine();
            if (moneyChoice.equals("1")) {
                machineBalance.addToLogFeeder("1");
            } else if (moneyChoice.equals("2")) {
                machineBalance.addToLogFeeder("2");
            } else if (moneyChoice.equals("5")) {
                machineBalance.addToLogFeeder("5");
            } else if (moneyChoice.equals("10")) {
                machineBalance.addToLogFeeder("10");
            } else if (moneyChoice.equals("0")) {
                feedMoneyMenuOpen = false;
            } else {
                System.out.print("\nThat was not a valid option.\n");
            }
        }
    }

}
