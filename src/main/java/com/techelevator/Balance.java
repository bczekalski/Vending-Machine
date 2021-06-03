package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Balance {

    private BigDecimal balance = BigDecimal.ZERO;
    private File log = new File("Log.txt");

    public BigDecimal getBalance() {
        return balance;
    }

    public void addMoney(double value) {
        balance = balance.add(BigDecimal.valueOf(value));
    }

    public void makeChange(){
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;

        while (balance.compareTo(BigDecimal.valueOf(.25)) >= 0){
            balance = balance.subtract(BigDecimal.valueOf(0.25));
            quarterCount++;
        }

        while (balance.compareTo(BigDecimal.valueOf(.10)) >= 0){
            balance = balance.subtract(BigDecimal.valueOf(0.10));
            dimeCount++;
        }

        if (balance.compareTo(BigDecimal.valueOf(.05)) >= 0){
            balance = balance.subtract(BigDecimal.valueOf(0.5));
            nickelCount++;
        }

        System.out.println("*** The Vending Machine Dispenses " + quarterCount + " Quarters, " + dimeCount + " Dimes, and " + nickelCount + " Nickels. Totaling to $"+ balance + " ***");

        System.out.println("Change has been returned. Balance is now $" + balance + ".");
    }

    public void addToLogProduct(Product purchasedProduct){

        try (PrintWriter writer = new PrintWriter(log);){
            Date date = new Date();
            Format formatter = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss aa");
            writer.print(">" + formatter.format(date) + " " + purchasedProduct.getProductName());
        }catch(FileNotFoundException e){
            System.out.println("You should not be reading this line! the Log file should already exist!");
        }


    }


}
