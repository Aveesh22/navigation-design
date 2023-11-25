package com.order.navigationdesign;

import java.util.ArrayList;
import java.util.Arrays;

public class Order
{
    private int orderNumber;
    private ArrayList<Pizza> pizzas;
    private double orderTotal;

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

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
}
