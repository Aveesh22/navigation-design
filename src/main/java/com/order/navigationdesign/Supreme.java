package com.order.navigationdesign;

public class Supreme extends Pizza
{
    @Override
    public double price()
    {
        double SM = 15.99;
        double MD = SM + 2;
        double LG = SM + 4;
        return switch (size) {
            case Size.SMALL -> SM;
            case Size.MEDIUM -> MD;
            case Size.LARGE -> LG;
        };
    }
}
