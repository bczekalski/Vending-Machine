package com.techelevator;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance() {
        return balance;
    }

    public void addMoney(int value) {
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

        System.out.println("*** The Vending Machine Dispenses " + quarterCount + " Quarters, " + dimeCount + " Dimes, and " + nickelCount + " Nickels. ***");

        System.out.println("Change has been returned. Balance is now $" + balance + ".");
    }


}
