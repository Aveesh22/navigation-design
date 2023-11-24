package com.order.navigationdesign;

public class BuildYourOwn extends Pizza {
    @Override
    public double price() {
        double SM = 8.99;
        double MD = SM + 2;
        double LG = SM + 4;
        double addTopping = 1.49;
        double minToppings = 3;

        double price = switch(size)
        {
            case SMALL -> SM;
            case MEDIUM -> MD;
            case LARGE -> LG;
        };

        if (toppings.size() > minToppings)
            price += addTopping * (toppings.size() - minToppings);
        return price;
    }
}
