package com.order.navigationdesign;


public class Meatzza extends Pizza
{
    @Override
    public double price()
    {
        if(size == Size.SMALL)
            return 16.99;
        else if(size == Size.MEDIUM)
            return 18.99;
        else if(size == Size.LARGE)
            return 20.99;
        return -1;
    }
}
