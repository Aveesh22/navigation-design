package com.order.navigationdesign;

public class BuildYourOwn extends Pizza {

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
        double extraCheeseAmt = 1;
        double extraSauceAmt = 1;

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
