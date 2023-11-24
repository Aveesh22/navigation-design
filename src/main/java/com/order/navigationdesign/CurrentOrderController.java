package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CurrentOrderController {

    @FXML
    private TextField orderTextField;

    @FXML
    private ListView ordersList;

    @FXML
    private TextField subtotalTextField;

    @FXML
    private TextField taxTextField;

    @FXML
    private TextField totalTextField;



    private final double SALES_TAX = 0.06625;
    private Order currOrder;

    private MainMenuController mainMenuController;



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
        String selectedOrder = (String) ordersList.getSelectionModel().getSelectedItem();
        ArrayList<Pizza> currOrderPizzas = currOrder.getPizzas();
        for (Pizza pizza : currOrderPizzas) {
            if (pizza.toString().equals(selectedOrder))
                currOrderPizzas.remove(pizza);
        }
        setOrdersList();
        setPrices();
    }

    @FXML
    protected void onPlaceOrderClick(Event event)
    {
        //add to StoreOrders
    }

    //Get the reference to the MainController object
    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }

    public void addPizza(SpecialtyPizzaController controller) {
        currOrder.addPizza(controller.getCurrPizza());
        setOrdersList();
        setPrices();
    }

    /**
     * Overloaded for BuildYourOwn pizzas
     * @param controller the BuildYourOwn controller
     */
    public void addPizza(BuildYourOwnController controller) {
        currOrder.addPizza(controller.getCurrPizza());
        setOrdersList();
        setPrices();
    }

    private void setOrdersList() {
        ArrayList<String> pizzaStrings = new ArrayList<>();
        for (Pizza pizza : currOrder.getPizzas()) {
            pizzaStrings.add(pizza.toString());
        }
        ordersList.setItems(FXCollections.observableArrayList(pizzaStrings));
    }

    private void setPrices() {
        double subtotal = 0.0;
        for (Pizza pizza : currOrder.getPizzas()) {
            subtotal += pizza.price();
        }
        subtotalTextField.setText(String.format("%.2f", subtotal));
        double tax = subtotal * SALES_TAX;
        taxTextField.setText(String.format("%.2f", tax));
        double total = subtotal + tax;
        totalTextField.setText(String.format("%.2f", total));
    }
}