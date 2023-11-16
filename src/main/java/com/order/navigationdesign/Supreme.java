package com.order.navigationdesign;

public class Supreme extends Pizza
{
    @Override
    public double price()
    {
        if(size == Size.SMALL)
            return 15.99;
        else if(size == Size.MEDIUM)
            return 17.99;
        else if(size == Size.LARGE)
            return 19.99;
        return -1;
    }
}
