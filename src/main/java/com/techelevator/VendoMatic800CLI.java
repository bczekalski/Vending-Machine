package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendoMatic800CLI {

    private static final Scanner in = new Scanner(System.in);
    private static final Inventory stock = new Inventory();
    private static final Balance machineBalance = new Balance();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu(){
        System.out.println("##########################################\n##### WELCOME TO THE VENDO-MATIC-800 #####\n##########################################");
        while(true) {
            // Display the main menu
            System.out.println("\n############### MAIN MENU ################");
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

    private static void purchaseMenu() {
        boolean purchaseWindowOpen = true;
        while (purchaseWindowOpen) {
            System.out.println("\n############# PURCHASE MENU ##############");
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
                        machineBalance.addMoney(-productToDispense.getPrice());
                        System.out.println("Now dispensing " + productToDispense.getProductName() + " which costs $" + productToDispense.getPrice());
                        System.out.println(stock.dispenseItem(productToDispense));
                        System.out.println("Money Remaining: $" + machineBalance.getBalance());
                    } else {
                        System.out.println("Please add additional money using the Feed Money option to purchase this product.");
                    }
                }
            } else if (purchaseChoice.equals("3")) {
                // Finish Transaction code
                machineBalance.makeChange();
                purchaseWindowOpen = false;
            } else {
                System.out.println("\nThat was not a valid option.\n");
            }
        }
    }

    private static void feedMoneyMenu() {
        boolean feedMoneyMenuOpen = true;
        while (feedMoneyMenuOpen) {
            System.out.println("\n############ FEED MONEY MENU #############");
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
                machineBalance.addMoney(1);
            } else if (moneyChoice.equals("2")) {
                machineBalance.addMoney(2);
            } else if (moneyChoice.equals("5")) {
                machineBalance.addMoney(5);
            } else if (moneyChoice.equals("10")) {
                machineBalance.addMoney(10);
            } else if (moneyChoice.equals("0")) {
                feedMoneyMenuOpen = false;
            } else {
                System.out.print("\nThat was not a valid option.\n");
            }
        }
    }

}
