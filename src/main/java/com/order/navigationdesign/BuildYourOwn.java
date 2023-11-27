package com.order.navigationdesign;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class defines a BuildYourOwn Pizza.
 * @author Patryk Dziedzic, Aveesh Patel
 */
public class BuildYourOwn extends Pizza {

    /**
     * No parameter constructor which creates a new ArrayList for toppings
     */
    public BuildYourOwn()
    {
        toppings = new ArrayList<>();
    }

    /**
     * Overridden method which calculates and returns the price of a BuildYourOwn pizza
     * @return a double depicting the price of the pizza
     */
    @Override
    public double price() {
        double SM = 8.99;
        double MD = SM + 2;
        double LG = SM + 4;
        double addTopping = 1.49;
        double minToppings = 3;
        double maxToppings = 7;
        double extraCheeseAmt = 1;
        double extraSauceAmt = 1;

        if (toppings.size() < minToppings || toppings.size() > maxToppings) return 0;

        double price = switch(size)
        {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };

        if (toppings.size() > minToppings)
            price += addTopping * (toppings.size() - minToppings);

        if(extraCheese) price += extraCheeseAmt;
        if(extraSauce) price += extraSauceAmt;

        return price;
    }
}
