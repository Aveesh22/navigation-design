package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Supreme extends Pizza
{
    /**
     * No parameter constructor which initializes the predefined states (sauce
     * and toppings) of a Supreme pizza
     */
    public Supreme()
    {
        sauce = Sauce.TOMATO;
        toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.HAM,
                Topping.GREEN_PEPPER, Topping.ONION, Topping.BLACK_OLIVE, Topping.MUSHROOM));
    }

    /**
     * Overriden method which calculates and returns the price of a Supreme pizza
     * @return a double depicting the price of the pizza
     */
    @Override
    public double price()
    {
        double SM = 15.99;
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
