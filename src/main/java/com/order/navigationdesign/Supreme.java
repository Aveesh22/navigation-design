package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Supreme extends Pizza
{
    public Supreme()
    {
        toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.HAM,
                Topping.GREEN_PEPPER, Topping.ONION, Topping.BLACK_OLIVE, Topping.MUSHROOM));
    }
    @Override
    public double price()
    {
        double SM = 15.99;
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
