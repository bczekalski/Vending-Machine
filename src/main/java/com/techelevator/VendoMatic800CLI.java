package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class VendoMatic800CLI {

    private static final String MAIN_MENU_DISPLAY = "(1) Display Vending Machine Items\n(2) Purchase\n(3) Exit\n\nPlease choose an option >>> ";
    private static final String PURCHASE_MENU_DISPLAY = "(1) Feed Money\n(2) Select Product\n(3) Finish Transaction\n\nCurrent Money Provided: $" + 10.00 + "\n\nPlease choose an option >>> ";
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        menuDisplay();
    }

    private static void menuDisplay(){
        while(true) {
            // Display the main menu
            System.out.print(MAIN_MENU_DISPLAY);
            String choice = in.nextLine();
            if (choice.equals("1")) {
                // Display vending machine items code
            } else if (choice.equals("2")) {
                // Go to purchase menu
                boolean purchaseWindowOpen = true;
                while (purchaseWindowOpen) {
                    System.out.print(PURCHASE_MENU_DISPLAY);
                    String purchaseChoice = in.nextLine();
                    if (purchaseChoice.equals("1")) {
                        // Feed Money code
                    } else if (purchaseChoice.equals("2")) {
                        // Select Product code
                    } else if (purchaseChoice.equals("3")) {
                        // Finish Transaction code
                        purchaseWindowOpen = false;
                    } else {
                        System.out.println("\nThat was not a valid option.\n");
                    }
                }
            } else if (choice.equals("3")) {
                System.exit(1);
            } else {
                System.out.println("\nThat was not a valid option.\n");
            }
        }
    }
}
