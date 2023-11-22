package com.order.navigationdesign;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StoreOrderController
{


    private MainMenuController mainMenuController;


    //Get the reference to the MainController object
    public void setMainController(MainMenuController controller){
        mainMenuController = controller;
    }

    private void populateListView(Order order) {

        for (Pizza pizza : order.getPizzas()) {
            //add to listview the pizza.toString()
        }
    }
}