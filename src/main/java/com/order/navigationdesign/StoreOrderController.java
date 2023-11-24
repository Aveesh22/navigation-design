package com.order.navigationdesign;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrderController
{

    @FXML
    private ComboBox orderNumber;

    @FXML
    private TextField orderTotal;

    @FXML
    private ListView pizzasList;


    private MainMenuController mainMenuController;
    private StoreOrders storeOrders;

    @FXML
    protected void onOrderChange(Event event) {

    }

    @FXML
    protected void onCancelOrderClick(Event event) {

    }

    @FXML
    protected void onExportStoreOrdersClick(Event event) {
        
    }


    //Get the reference to the MainController object
    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }

    private void populateListView(Order order)
    {

        for (Pizza pizza : order.getPizzas()) {
            //add to listview the pizza.toString()
        }
    }
}