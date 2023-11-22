package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Pepperoni extends Pizza
{
    public Pepperoni()
    {
        toppings = new ArrayList<>(Arrays.asList(Topping.PEPPERONI));
    }

    @Override
    public double price()
    {
        double SM = 10.99;
        double MD = SM + 2;
        double LG = SM + 4;
        return switch (size) {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };
    }
}
