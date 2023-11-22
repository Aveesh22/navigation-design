package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class CurrentOrderController {


    private final double SALES_TAX = 1.06625;

    private MainMenuController mainMenuController;
    private Order currOrder;


    @FXML
    private void initialize()
    {
        currOrder = new Order();
        currOrder.setOrderNumber(0); //dependent on StoreOrders nextOrderNumber variable
        //now increment nextOrderNumber++
        currOrder.setPizzas(new ArrayList<>());
    }

    @FXML
    protected void onRemovePizzaClick(Event event)
    {
        //currOrder.getPizzas().remove( the pizza from list view )
    }

    @FXML
    protected void onPlaceOrderClick(Event event)
    {
        //add to StoreOrders
    }

    //Get the reference to the MainController object
    public void setMainController(MainMenuController controller){
        mainMenuController = controller;
    }

    public void addSpecialtyPizza(SpecialtyPizzaController controller) {
        currOrder.addPizza(controller.getCurrPizza());
        //add pizza.toString() to the ListView in current orders

        double subtotal = 0.0;
        for (Pizza pizza : currOrder.getPizzas()) {
            subtotal += pizza.price();
        }
        //then print subtotal
        double tax = subtotal * SALES_TAX;
        //then print tax
        double total = subtotal + tax;
        //then print total
    }
}