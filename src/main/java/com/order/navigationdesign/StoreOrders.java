package com.order.navigationdesign;

import java.util.ArrayList;
public class StoreOrders
{
    private ArrayList<Order> ordersList;

    private static int nextOrderNumber;

    public StoreOrders() {
        ordersList = new ArrayList<>();
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    public void addOrder(Order order) {
        ordersList.add(order);
    }

    public void removeOrder(Order order) {
        ordersList.remove(order);
    }

    public static int getNextOrderNumber() {
        return nextOrderNumber;
    }

    public static void setNextOrderNumber(int nextOrderNumber) {
        StoreOrders.nextOrderNumber = nextOrderNumber;
    }

    public static void incrementNextOrderNumber() {
        StoreOrders.nextOrderNumber++;
    }

    public void export()
    {
        //write to text file
    }
}
