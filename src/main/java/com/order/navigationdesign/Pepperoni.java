package com.order.navigationdesign;

public class Pepperoni extends Pizza
{
    @Override
    public double price()
    {
        if(size == Size.SMALL)
            return 10.99;
        else if(size == Size.MEDIUM)
            return 12.99;
        else if(size == Size.LARGE)
            return 14.99;
        return -1;
    }
}
