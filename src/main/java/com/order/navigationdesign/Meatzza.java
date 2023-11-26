package com.order.navigationdesign;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza
{
    /**
     * No parameter constructor which initializes the predefined states (sauce
     * and toppings) of a Meatzza pizza
     */
    public Meatzza()
    {
        sauce = Sauce.TOMATO;
        toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM));
    }

    /**
     * Overridden method which calculates and returns the price of a Meatzza pizza
     * @return a double depicting the price of the pizza
     */
    @Override
    public double price()
    {
        double SM = 16.99;
        double MD = SM + 2;
        double LG = SM + 4;
        double extraCheeseAmt = 1;
        double extraSauceAmt = 1;

        double price = switch (size)
        {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };

        if(extraCheese) price += extraCheeseAmt;
        if(extraSauce) price += extraSauceAmt;

        return price;
    }
}
