package com.order.navigationdesign;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * This class tests the BuildYourOwn class price() method.
 * @author Aveesh Patel, Patryk Dziedzic
 */
public class BuildYourOwnTest {
    private final double SMALL_PRICE = 8.99;
    private final double MEDIUM_PRICE = SMALL_PRICE + 2;
    private final double LARGE_PRICE = SMALL_PRICE + 4;
    private final double ADDITIONAL_TOPPING = 1.49;
    private final double EXTRA_SAUCE = 1.00;
    private final double EXTRA_CHEESE = 1.00;

    /**
     * Test a number of toppings that is less than the minimum required.
     */
    @Test
    public void testNumToppings_NotEnough()
    {
        Pizza buildYourOwn = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwn.toppings.add(Topping.SAUSAGE);
        buildYourOwn.size = Size.SMALL;
        buildYourOwn.sauce = Sauce.TOMATO;
        assertEquals(0.0, buildYourOwn.price(), 0.0);
    }

    /**
     * Test a number of toppings that exceeds the maximum allowed.
     */
    @Test
    public void testNumToppings_TooMany()
    {
        Pizza buildYourOwn = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwn.toppings.addAll(Arrays.asList(Topping.values())); //add all possible toppings
        buildYourOwn.size = Size.SMALL;
        buildYourOwn.sauce = Sauce.TOMATO;
        assertEquals(0.0, buildYourOwn.price(), 0.0);
    }

    /**
     * Test that a BuildYourOwn pizza can be created with all possible sizes.
     */
    @Test
    public void allPizzaSizeCreationSuccess()
    {
        Pizza buildYourOwn = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwn.toppings.add(Topping.SAUSAGE);
        buildYourOwn.toppings.add(Topping.PEPPERONI);
        buildYourOwn.toppings.add(Topping.HAM);
        buildYourOwn.sauce = Sauce.TOMATO;

        buildYourOwn.size = Size.SMALL;
        assertEquals(SMALL_PRICE, buildYourOwn.price(), 0.0);
        buildYourOwn.size = Size.MEDIUM;
        assertEquals(MEDIUM_PRICE, buildYourOwn.price(), 0.0);
        buildYourOwn.size = Size.LARGE;
        assertEquals(LARGE_PRICE, buildYourOwn.price(), 0.0);
    }

    /**
     * Test that there is no additional charge with 3 toppings.
     */
    @Test
    public void noAdditionalCharge_ThreeToppings()
    {
        Pizza buildYourOwn = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwn.toppings.add(Topping.SAUSAGE);
        buildYourOwn.toppings.add(Topping.PEPPERONI);
        buildYourOwn.toppings.add(Topping.HAM);
        buildYourOwn.size = Size.SMALL;
        buildYourOwn.sauce = Sauce.TOMATO;
        assertFalse(buildYourOwn.price() > SMALL_PRICE);
    }

    /**
     * Test that the additional charge is added successfully with more than 3 toppings.
     */
    @Test
    public void additionalCharge_MoreThanThreeToppings()
    {
        Pizza buildYourOwn = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwn.toppings.add(Topping.SAUSAGE);
        buildYourOwn.toppings.add(Topping.PEPPERONI);
        buildYourOwn.toppings.add(Topping.HAM);
        buildYourOwn.toppings.add(Topping.BEEF);
        buildYourOwn.size = Size.SMALL;
        buildYourOwn.sauce = Sauce.TOMATO;
        assertEquals(SMALL_PRICE + ADDITIONAL_TOPPING, buildYourOwn.price(), 0.0);
    }

    /**
     * Test that extra sauce increases the price successfully when selected.
     */
    @Test
    public void extraSauce_CorrectIncrease()
    {
        Pizza buildYourOwn = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwn.toppings.add(Topping.SAUSAGE);
        buildYourOwn.toppings.add(Topping.PEPPERONI);
        buildYourOwn.toppings.add(Topping.HAM);
        buildYourOwn.size = Size.SMALL;
        buildYourOwn.sauce = Sauce.TOMATO;
        buildYourOwn.extraSauce = true;
        assertEquals(SMALL_PRICE + EXTRA_SAUCE, buildYourOwn.price(), 0.0);
    }

    /**
     * Test that extra cheese increases the price successfully when selected.
     */
    @Test
    public void extraCheese_CorrectIncrease()
    {
        Pizza buildYourOwn = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwn.toppings.add(Topping.SAUSAGE);
        buildYourOwn.toppings.add(Topping.PEPPERONI);
        buildYourOwn.toppings.add(Topping.HAM);
        buildYourOwn.size = Size.SMALL;
        buildYourOwn.sauce = Sauce.TOMATO;
        buildYourOwn.extraCheese = true;
        assertEquals(SMALL_PRICE + EXTRA_CHEESE, buildYourOwn.price(), 0.0);
    }
}