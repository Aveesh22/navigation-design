package com.order.navigationdesign;

public class StoreOrderController
{

    private MainMenuController mainMenuController;


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