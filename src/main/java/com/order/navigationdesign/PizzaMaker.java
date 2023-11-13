package com.order.navigationdesign;

//create an instance of subclasses based on the chosen pizza type
public class PizzaMaker
{
    public static Pizza createPizza(String pizzaType)
    {
        return new BuildYourOwn();

    }
}