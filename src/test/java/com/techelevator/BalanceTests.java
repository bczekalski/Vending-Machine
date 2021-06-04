package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class BalanceTests {
    Balance balance = new Balance();


    @Test
    public void get_balance_test_should_return_0(){
        Assert.assertEquals(balance.getBalance(), BigDecimal.ZERO);
    }

    @Test
    public void test_add_money_adding_100_dollars_to_balance(){
        balance.addMoney(100.0);
        Assert.assertEquals(balance.getBalance(), BigDecimal.valueOf(100.0));
    }

    @Test
    public void add_negative_20_dollars_should_return_80(){
        balance.addMoney(100.0);
        balance.addMoney(-20.0);
        Assert.assertEquals(balance.getBalance(), BigDecimal.valueOf(80.0));
    }

    @Test
    public void test_change_maker_from_20_dollars(){
        balance.addMoney(20.0);
        balance.makeChange();
        Assert.assertEquals(balance.getBalance(), BigDecimal.ZERO);
    }


}
