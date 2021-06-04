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
    private static final Menu machineMenu = new Menu(in, stock, machineBalance);

    public static void main(String[] args) {
        machineMenu.mainMenu();
    }
}
