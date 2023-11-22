package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza
{
    public Deluxe()
    {
        toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI,
                Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
    }

    @Override
    public double price()
    {
        double SM = 14.99;
        double MD = SM + 2;
        double LG = SM + 4;
        return switch (size) {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };
    }

}
