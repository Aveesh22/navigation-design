package com.order.navigationdesign;

import java.util.ArrayList;
public class StoreOrders
{
    private ArrayList<StoreOrders> ordersList;

    private static int nextOrderNumber;

    public ArrayList<StoreOrders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(ArrayList<StoreOrders> ordersList) {
        this.ordersList = ordersList;
    }

    public static int getNextOrderNumber() {
        return nextOrderNumber;
    }

    public static void incrementNextOrderNumber() {
        StoreOrders.nextOrderNumber++;
    }

    public void export()
    {

    }
}
