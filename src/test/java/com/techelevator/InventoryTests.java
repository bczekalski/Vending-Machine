package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class InventoryTests {

    @Test
    public void get_items_remaining_test_for_b3_should_return_5(){
        Inventory stock = new Inventory();
        Assert.assertEquals("5", stock.getItemsRemaining(stock.getStringToProduct("B3")));
    }

    @Test
    public void get_items_remaining_after_d2_dispensed_twice(){
        Inventory stock = new Inventory();
        Product product = stock.getStringToProduct("D2");
        String temp = stock.dispenseItem(product);
        temp = stock.dispenseItem(product);
        Assert.assertEquals("3", stock.getItemsRemaining(product));
    }

    @Test
    public void get_items_remaining_should_return_SOLD_OUT_after_5_dispenses(){
        Inventory stock = new Inventory();
        Product product = stock.getStringToProduct("D4");
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        Assert.assertEquals("SOLD OUT", stock.getItemsRemaining(product));
    }

    @Test
    public void test_is_sold_out_should_return_true(){
        Inventory stock = new Inventory();
        Product product = stock.getStringToProduct("A2");
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        Assert.assertTrue(stock.isSoldOut(product));
    }

    @Test
    public void test_is_sold_out_should_return_false(){
        Inventory stock = new Inventory();
        Product product = stock.getStringToProduct("A2");
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        Assert.assertFalse(stock.isSoldOut(product));
    }

    @Test
    public void test_item_does_not_exist_should_return_false(){
        Inventory stock = new Inventory();
        Assert.assertFalse(stock.itemExists("A5"));
    }

    @Test
    public void test_dispense_6_items_then_ask_for_return(){
        Inventory stock = new Inventory();
        Product product = stock.getStringToProduct("A2");
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        stock.dispenseItem(product);
        Assert.assertEquals("SOLD OUT", stock.getItemsRemaining(product));
    }




}
