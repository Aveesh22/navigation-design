package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Seafood extends Pizza
{
    public Seafood()
    {
        toppings = new ArrayList<>(Arrays.asList(Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEATS));
    }

    @Override
    public double price()
    {
        double SM = 17.99;
        double MD = SM + 2;
        double LG = SM + 4;
        return switch (size)
        {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };
    }
}
