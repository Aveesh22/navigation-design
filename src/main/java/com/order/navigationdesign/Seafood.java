package com.order.navigationdesign;

public class Seafood extends Pizza
{
    @Override
    public double price()
    {
        if(size == Size.SMALL)
            return 17.99;
        else if(size == Size.MEDIUM)
            return 19.99;
        else if(size == Size.LARGE)
            return 21.99;
        return -1;
    }
}
