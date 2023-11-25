package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CurrentOrderController {

    @FXML
    private TextField orderTextField;

    @FXML
    private ListView pizzasList;

    @FXML
    private TextField subtotalTextField;

    @FXML
    private TextField taxTextField;

    @FXML
    private TextField totalTextField;


    private MainMenuController mainMenuController;
    private final double SALES_TAX = 0.06625;
    private Order currOrder;


    @FXML
    private void initialize() {
        createNewOrder();
    }

    @FXML
    protected void onRemovePizzaClick(Event event)
    {
        String selectedOrder = (String) pizzasList.getSelectionModel().getSelectedItem();
        ArrayList<Pizza> newCurrOrderPizzas = (ArrayList<Pizza>) currOrder.getPizzas().clone();
        for (Pizza pizza : currOrder.getPizzas()) {
            if (pizza.toString().equals(selectedOrder))
                newCurrOrderPizzas.remove(pizza);
        }
        currOrder.setPizzas(newCurrOrderPizzas);
        setPizzasList();
        setPrices();
    }

    @FXML
    protected void onPlaceOrderClick(Event event)
    {
        if (pizzasList.getItems() != null) {
            StoreOrderController SOController = mainMenuController.getSOController();
            SOController.addOrder(currOrder);
            createNewOrder();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Empty Order");
            alert.setContentText("Add pizzas before selecting Place Order.");
            alert.showAndWait();
        }
    }

    //Get the reference to the MainController object
    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }

    public void addPizza(SpecialtyPizzaController controller) {
        if (currOrder == null) createNewOrder();
        currOrder.addPizza(controller.getCurrPizza());
        setPizzasList();
        setPrices();
    }

    /**
     * Overloaded for BuildYourOwn pizzas
     * @param controller the BuildYourOwn controller
     */
    public void addPizza(BuildYourOwnController controller) {
        if (currOrder == null) createNewOrder();
        currOrder.addPizza(controller.getCurrPizza());
        setPizzasList();
        setPrices();
    }

    private void setPizzasList() {
        ArrayList<String> pizzaStrings = new ArrayList<>();
        for (Pizza pizza : currOrder.getPizzas()) {
            pizzaStrings.add(pizza.toString());
        }
        pizzasList.setItems(FXCollections.observableArrayList(pizzaStrings));
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
        currOrder.setOrderTotal(total);
    }

    private void createNewOrder() {
        currOrder = new Order();
        int nextOrderNumber = StoreOrders.getNextOrderNumber();
        currOrder.setOrderNumber(nextOrderNumber);
        orderTextField.setText(Integer.toString(nextOrderNumber));
        StoreOrders.incrementNextOrderNumber();
        currOrder.setPizzas(new ArrayList<>());
        setPizzasList();
        setPrices();
    }
}