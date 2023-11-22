package com.order.navigationdesign;

import java.util.ArrayList;

public abstract class Pizza
{
    protected ArrayList<Topping> toppings; //Topping is an enum class
    protected Size size; //Size is an enum class
    protected Sauce sauce; //Sauce is an enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    public abstract double price(); //polymorphism

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(getClass()).append("] ");
        for (int i = 0; i < toppings.size(); i++) {
            sb.append(toppings.get(i).getName());
            if (i < toppings.size() - 1) sb.append(", ");
        }
        if (extraSauce) sb.append(", Extra Sauce");
        if (extraCheese) sb.append(", Extra Cheese");
        sb.append(" $").append(String.format("%.2f", price()));
        return sb.toString();
    }
}
