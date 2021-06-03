package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private Product productUnderTest;
    private Product chipUnderTest;
    private Product gumUnderTest;
    private Product drinkUnderTest;
    private Product candyUnderTest;

    @Before
    public void new_object_maker() {
        productUnderTest = new Product("A1", "Crunchie Bits", "0.50");
        chipUnderTest = new Chip("B2", "Grain Waves", "1.50");
        gumUnderTest = new Gum("C3", "U-Chews", "2.55");
        drinkUnderTest = new Drink("D4", "Cola", "3.00");
        candyUnderTest = new Candy("A2", "Cowtales", "1.20");
    }


    @Test
    public void get_price_test() {
        double expected = 0.50;
        double actual = productUnderTest.getPrice();
        Assert.assertEquals(expected, actual, 0.00);
        expected = 1.50;
        actual = chipUnderTest.getPrice();
        Assert.assertEquals(expected, actual, 0.00);
        expected = 2.55;
        actual = gumUnderTest.getPrice();
        Assert.assertEquals(expected, actual, 0.00);
        expected = 3.00;
        actual = drinkUnderTest.getPrice();
        Assert.assertEquals(expected, actual, 0.00);
        expected = 1.20;
        actual = candyUnderTest.getPrice();
        Assert.assertEquals(expected, actual, 0.00);
    }

    @Test
    public void get_slot_location_test() {
        String expected = "A1";
        String actual = productUnderTest.getSlotLocation();
        Assert.assertEquals(expected, actual);
        expected = "B2";
        actual = chipUnderTest.getSlotLocation();
        Assert.assertEquals(expected, actual);
        expected = "C3";
        actual = gumUnderTest.getSlotLocation();
        Assert.assertEquals(expected, actual);
        expected = "D4";
        actual = drinkUnderTest.getSlotLocation();
        Assert.assertEquals(expected, actual);
        expected = "A2";
        actual = candyUnderTest.getSlotLocation();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get_product_name_test() {
        String expected = "Crunchie Bits";
        String actual = productUnderTest.getProductName();
        Assert.assertEquals(expected, actual);
        expected = "Grain Waves";
        actual = chipUnderTest.getProductName();
        Assert.assertEquals(expected, actual);
        expected = "U-Chews";
        actual = gumUnderTest.getProductName();
        Assert.assertEquals(expected, actual);
        expected = "Cola";
        actual = drinkUnderTest.getProductName();
        Assert.assertEquals(expected, actual);
        expected = "Cowtales";
        actual = candyUnderTest.getProductName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get_phrases_from_item_dispensed_test() {
        String expected = "Crunch Crunch, Yum!";
        String actual = chipUnderTest.itemDispensed();
        Assert.assertEquals(expected, actual);
        expected = "Chew Chew, Yum!";
        actual = gumUnderTest.itemDispensed();
        Assert.assertEquals(expected, actual);
        expected = "Glug Glug, Yum!";
        actual = drinkUnderTest.itemDispensed();
        Assert.assertEquals(expected, actual);
        expected = "Munch Munch, Yum!";
        actual = candyUnderTest.itemDispensed();
        Assert.assertEquals(expected, actual);
    }

}
