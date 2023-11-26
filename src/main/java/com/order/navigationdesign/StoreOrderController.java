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

    /**
     * Adds an order to Store Orders
     * @param order the order to be added
     */
    public void addOrder(Order order) {
        storeOrders.addOrder(order);
        populateOrderNumbers();
    }

    /**
     * Initializes the UI with the necessary components to create a fully
     * functional Store Orders GUI
     */
    @FXML
    private void initialize()
    {
        storeOrders = new StoreOrders();
        populateOrderNumbers();
    }

    /**
     * Correctly changes the list of store orders and associated properties when a change is detected
     * @param event the event of changing the store orders
     */
    @FXML
    protected void onOrderChange(Event event)
    {
        updateView();
    }

    /**
     * Cancels a particular order on the click of the cancel order button
     * @param event the click of the cancel order button
     */
    @FXML
    protected void onCancelOrderClick(Event event) {
        Order currOrder = getSelectedOrder();
        storeOrders.removeOrder(currOrder);
        populateOrderNumbers();
        updateView();
    }

    /**
     * Exports the entire list of orders into a .txt file on the click of the export store orders button
     * @param event the click of the export store orders button
     */
    @FXML
    protected void onExportStoreOrdersClick(Event event)
    {
        storeOrders.export();
    }


    /**
     * Gets the reference to the MainMenuController object instance
     * @param controller the MainMenuController
     */
    public void setMainMenuController(MainMenuController controller)
    {
        mainMenuController = controller;
    }

    /**
     * Populates the order numbers
     */
    private void populateOrderNumbers()
    {
        ArrayList<String> numbers = new ArrayList<>();
        for (Order order : storeOrders.getOrdersList()) {
            numbers.add(String.valueOf(order.getOrderNumber()));
        }
        orderNumbers.setItems(FXCollections.observableArrayList(numbers));
    }

    /**
     * Populates the pizza list for a particular order
     * @param order the order to be populated
     */
    private void populatePizzasList(Order order)
    {
        ArrayList<String> pizzaStrings = new ArrayList<>();
        for (Pizza pizza : order.getPizzas()) {
            pizzaStrings.add(pizza.toString());
        }
        pizzasList.setItems(FXCollections.observableArrayList(pizzaStrings));
    }

    /**
     * Returns order information regarding a specified order (through its respective number)
     * @return the order
     */
    private Order getSelectedOrder() {
        String orderNumber = (String) orderNumbers.getSelectionModel().getSelectedItem();
        if (orderNumber == null || orderNumber.isEmpty()) return null;
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

    /**
     * Updates the view of store orders when a critical action occurs to a particular order
     */
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