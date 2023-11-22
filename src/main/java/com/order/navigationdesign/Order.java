package com.order.navigationdesign;

import java.util.ArrayList;
import java.util.Arrays;

public class Order
{
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /*
    public String pizzaToString(Pizza pizza)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pizza.getClass()).append("] ");
        for (int i = 0; i < pizza.toppings.size(); i++) {
            sb.append(pizza.toppings.get(i).getName());
            if (i < pizza.toppings.size() - 1) sb.append(", ");
        }
        if (pizza.extraSauce) sb.append(", Extra Sauce");
        if (pizza.extraCheese) sb.append(", Extra Cheese");
        sb.append(" $").append(String.format("%.2f", pizza.price()));
        return sb.toString();
    }
     */
}
