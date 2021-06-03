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


}
