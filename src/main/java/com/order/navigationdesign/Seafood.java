package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Seafood extends Pizza
{
    /**
     * No parameter constructor which initializes the predefined states (sauce
     * and toppings) of a Seafood pizza
     */
    public Seafood()
    {
        sauce = Sauce.ALFREDO;
        toppings = new ArrayList<>(Arrays.asList(Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEATS));
    }

    /**
     * Overridden method which calculates and returns the price of a Seafood pizza
     * @return a double depicting the price of the pizza
     */
    @Override
    public double price()
    {
        double SM = 17.99;
        double MD = SM + 2;
        double LG = SM + 4;

        double price = switch (size)
        {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };

        if(extraCheese) price += 1;
        if(extraSauce) price += 1;

        return price;
    }
}
