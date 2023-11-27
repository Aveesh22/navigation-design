package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * This class defines the Controller for the CurrentOrderView.
 * @author Patryk Dziedzic, Aveesh Patel
 */
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


    private final double SALES_TAX = 0.06625;
    private MainMenuController mainMenuController;
    private Order currOrder;

    /**
     * Initializes the UI with the necessary components to create a functional GUI, namely,
     * by creating a new order
     */
    @FXML
    private void initialize()
    {
        createNewOrder();
    }

    /**
     * On the click of the remove pizza button, the selected pizza is removed and
     * the list of selected pizzas and their respective prices are updated
     * @param event the event of clicking the remove button
     */
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

    /**
     * On the click of the place order button, the selected pizzas in the order
     * are sent to a created and instantiated StoreOrderController instance
     * @param event the event of clicking the place order button
     */
    @FXML
    protected void onPlaceOrderClick(Event event)
    {
        if (pizzasList.getItems() != null) {
            StoreOrderController SOController = mainMenuController.getSOController();
            SOController.addOrder(currOrder);
            createNewOrder();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ORDER CONFIRMATION");
            alert.setHeaderText("Order Placed");
            alert.setContentText("Order Placed to Store Orders!");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Empty Order");
            alert.setContentText("Add pizzas before selecting Place Order.");
            alert.showAndWait();
        }
    }

    /**
     * Gets the reference of the MainMenuController object
     * @param controller the MainMenuController
     */
    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }

    /**
     * An overloaded method to add a pizza to the current order given that it
     * is a Specialty Pizza
     * @param controller the SpecialtyPizzaController that sends data about the specialty
     *                   pizza to be added
     */
    public void addPizza(SpecialtyPizzaController controller) {
        if (currOrder == null) createNewOrder();
        currOrder.addPizza(controller.getCurrPizza());
        setPizzasList();
        setPrices();
    }

    /**
     * An overloaded method to add a pizza to the current order given that it
     * is a BuildYourOwn Pizza
     * @param controller the SpecialtyPizzaController that sends data about the specialty
     *                   pizza to be added
     */
    public void addPizza(BuildYourOwnController controller) {
        if (currOrder == null) createNewOrder();
        currOrder.addPizza(controller.getCurrPizza());
        setPizzasList();
        setPrices();
    }

    /**
     * Sets the pizzasList ListView to the pizzas that are in the current order
     */
    private void setPizzasList() {
        ArrayList<String> pizzaStrings = new ArrayList<>();
        for (Pizza pizza : currOrder.getPizzas()) {
            pizzaStrings.add(pizza.toString());
        }
        pizzasList.setItems(FXCollections.observableArrayList(pizzaStrings));
    }

    /**
     * Sets the three price fields (subtotal, tax, and total prices) for the order
     */
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

    /**
     * Creates a new order
     */
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