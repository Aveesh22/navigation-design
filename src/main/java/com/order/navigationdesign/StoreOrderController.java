package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StoreOrderController
{

    @FXML
    private ComboBox orderNumbers;

    @FXML
    private TextField orderTotal;

    @FXML
    private ListView pizzasList;


    private MainMenuController mainMenuController;
    private StoreOrders storeOrders;

    public void addOrder(Order order) {
        storeOrders.addOrder(order);
        populateOrderNumbers();
    }

    @FXML
    private void initialize()
    {
        storeOrders = new StoreOrders();
        populateOrderNumbers();
    }

    @FXML
    protected void onOrderChange(Event event) {
        updateView();
    }

    @FXML
    protected void onCancelOrderClick(Event event) {
        Order currOrder = getSelectedOrder();
        storeOrders.removeOrder(currOrder);
        populateOrderNumbers();
        updateView();
    }

    @FXML
    protected void onExportStoreOrdersClick(Event event) {
        storeOrders.export();
    }


    //Get the reference to the MainController object
    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }

    private void populateOrderNumbers() {
        ArrayList<String> numbers = new ArrayList<>();
        for (Order order : storeOrders.getOrdersList()) {
            numbers.add(String.valueOf(order.getOrderNumber()));
        }
        orderNumbers.setItems(FXCollections.observableArrayList(numbers));
    }

    private void populatePizzasList(Order order)
    {
        ArrayList<String> pizzaStrings = new ArrayList<>();
        for (Pizza pizza : order.getPizzas()) {
            pizzaStrings.add(pizza.toString());
        }
        pizzasList.setItems(FXCollections.observableArrayList(pizzaStrings));
    }

    private Order getSelectedOrder() {
        String orderNumber = (String) orderNumbers.getSelectionModel().getSelectedItem();
        ArrayList<Order> ordersList = storeOrders.getOrdersList();
        Order currOrder = null;
        for (Order order : ordersList) {
            if (order.getOrderNumber() == Integer.parseInt(orderNumber)) {
                currOrder = order;
                break;
            }
        }
        return currOrder;
    }

    private void updateView() {
        Order currOrder = getSelectedOrder();
        if (currOrder != null) {
            orderTotal.setText(String.format("%.2f", currOrder.getOrderTotal()));
            populatePizzasList(currOrder);
        }
        else {
            orderTotal.setText("");
            pizzasList.setItems(null);
        }
    }
}