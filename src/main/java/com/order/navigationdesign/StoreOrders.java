package com.order.navigationdesign;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class StoreOrders
{
    private ArrayList<Order> ordersList;

    private static int nextOrderNumber;

    /**
     * No-parameter constructor which initializes the ordersList to an empty ArrayList of type Order
     */
    public StoreOrders()
    {
        ordersList = new ArrayList<>();
    }

    /**
     * Getter method which returns the ordersList
     * @return the ordersList
     */
    public ArrayList<Order> getOrdersList()
    {
        return ordersList;
    }

    /**
     * Adds an order to ordersList
     * @param order the order to be added
     */
    protected void addOrder(Order order)
    {
        ordersList.add(order);
    }

    /**
     * Removes an order from ordersList
     * @param order the order to be removed
     */
    public void removeOrder(Order order)
    {
        ordersList.remove(order);
    }

    /**
     * Gets the next orderNumber
     * @return the integer depicting the nextOrderNumber
     */
    public static int getNextOrderNumber()
    {
        return nextOrderNumber;
    }

    /**
     * Sets the nextOrderNumber as specified by the integer parameter
     * @param nextOrderNumber the integer for the nextOrderNumber
     */
    public static void setNextOrderNumber(int nextOrderNumber)
    {
        StoreOrders.nextOrderNumber = nextOrderNumber;
    }

    /**
     * Increments the static nextOrderNumber variable so no two orders
     * have the same number
     */
    public static void incrementNextOrderNumber()
    {
        StoreOrders.nextOrderNumber++;
    }

    /**
     * Exports all orders in ordersList to a .txt file
     */
    public void export()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Target File for Saving the Orders List");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = fileChooser.showSaveDialog(new Stage());

        if(file != null)
        {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
            {
                for(Order order: ordersList)
                {
                    writer.write(order.toString());
                }
            }
            catch(IOException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Error When Writing");
                alert.setContentText("An error has occurred when trying to write to the file.");
                alert.showAndWait();
            }
        }
    }
}
