package com.order.navigationdesign;

public class Deluxe extends Pizza
{
    @Override
    public double price()
    {
        if(size == Size.SMALL)
            return 14.99;
        else if(size == Size.MEDIUM)
            return 16.99;
        else if(size == Size.LARGE)
            return 18.99;
        return -1;
    }

}
