package com.order.navigationdesign;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza
{
    public Meatzza()
    {
        toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM));
    }

    @Override
    public double price()
    {
        double SM = 16.99;
        double MD = SM + 2;
        double LG = SM + 4;
        return switch (size) {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };
    }
}
