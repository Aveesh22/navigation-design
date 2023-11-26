package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BuildYourOwnController {

    @FXML
    private ImageView pizzaImage;

    @FXML
    private ComboBox pizzaSize;

    @FXML
    private RadioButton tomatoSauceButton;

    @FXML
    private RadioButton alfredoSauceButton;

    @FXML
    private CheckBox extraSauceCheckBox;

    @FXML
    private CheckBox extraCheeseCheckBox;

    @FXML
    private ListView additionalToppingsList;

    @FXML
    private Button addToppingButton;

    @FXML
    private Button removeToppingButton;

    @FXML
    private ListView selectedToppingsList;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button addToOrderButton;

    private final double EXTRA_SAUCE = 1.00;
    private final double EXTRA_CHEESE = 1.00;
    private final int MIN_TOPPINGS = 3;
    private final int MAX_TOPPINGS = 7;
    private MainMenuController mainMenuController;
    private ObservableList<String> pizzaSizeList;
    private Pizza currPizza;

    /**
     * Gets the current BuildYourOwn pizza instance
     * @return the BuildYourOwn pizza instance
     */
    public Pizza getCurrPizza()
    {
        return currPizza;
    }

    /**
     * Gets the reference to the MainMenuController object instance from this (BuildYourOwnController) controller
     * @param controller the reference to the MainMenuController object instance
     */
    public void setMainMenuController(MainMenuController controller)
    {
        mainMenuController = controller;
    }

    /**
     * Initializes the UI with the necessary components to create a functional GUI
     * that can effectively build a BuildYourOwn pizza through user specs
     */
    @FXML
    private void initialize()
    {
        pizzaSizeList = FXCollections.observableArrayList(Size.SMALL.getName(), Size.MEDIUM.getName(), Size.LARGE.getName());
        pizzaSize.setItems(pizzaSizeList);
        pizzaSize.setValue(Size.SMALL.getName());
        resetToppings();
    }

    /**
     * Creates a new pizza instance (when necessary) when a property of the pizza is changed
     * @param event the event for when a pizza is changed
     */
    @FXML
    protected void onPizzaChange(Event event)
    {
        createPizza();
    }

    /**
     * Creates a new pizza instance with the modification of with or without extra sauce
     * and respectively changes the property of the currPizza to reflect it
     * @param event the enabling or disabling of the extraSauce checkbox
     */
    @FXML
    protected void onExtraSauceChange(Event event)
    {
        createPizza();
        currPizza.extraSauce = extraSauceCheckBox.isSelected();
    }

    /**
     * Creates a new pizza instance with the modification of with or without extra sauce
     * and respectively changes the property of the currPizza to reflect it
     * @param event the enabling or disabling of the extraSauce checkbox
     */
    @FXML
    protected void onExtraCheeseChange(Event event)
    {
        createPizza();
        currPizza.extraCheese = extraCheeseCheckBox.isSelected();
    }

    /**
     * On the click of the add button, a specific topping goes from the additional
     * toppings to the selected toppings
     * @param event the click of the add button
     */
    @FXML
    protected void onAddToppingButtonClick(Event event)
    {
        if (selectedToppingsList.getItems().size() == MAX_TOPPINGS)
            tooManyToppings();
        else {
            Object selectedTopping = additionalToppingsList.getSelectionModel().getSelectedItem();
            if (selectedTopping != null) {
                selectedToppingsList.getItems().add(selectedTopping);
                additionalToppingsList.getItems().remove(selectedTopping);
                createPizza();
            }
        }
    }

    /**
     * On the click of the remove button, a specific topping goes from the selected
     * toppings to the additional toppings
     * @param event the click of the remove button
     */
    @FXML
    protected void onRemoveToppingButtonClick(Event event)
    {
        Object selectedTopping = selectedToppingsList.getSelectionModel().getSelectedItem();
        if (selectedTopping != null) {
            additionalToppingsList.getItems().add(selectedTopping);
            selectedToppingsList.getItems().remove(selectedTopping);
            createPizza();
        }
    }

    /**
     * On the click of the add to order button create the pizza and pass the information
     * of the pizza to the CurrentOrderController to eventually place the order
     * @param event the click of the add to order button
     */
    @FXML
    protected void onAddToOrderButtonClick(Event event)
    {
        if (selectedToppingsList.getItems().size() < MIN_TOPPINGS)
            notEnoughToppings();
        else if (selectedToppingsList.getItems().size() > MAX_TOPPINGS)
            tooManyToppings();
        else {
            createPizza();
            CurrentOrderController COController = mainMenuController.getCOController();
            COController.addPizza(this);
            resetToppings();
        }
    }

    /**
     * Uses the PizzaMaker to create a new BuildYourOwn pizza with the specifications
     * specified by the user
     */
    private void createPizza()
    {
        currPizza = PizzaMaker.createPizza("BuildYourOwn");
        String size = (String) pizzaSize.getValue();
        if (size.equals(Size.SMALL.getName())) currPizza.size = Size.SMALL;
        else if (size.equals(Size.MEDIUM.getName())) currPizza.size = Size.MEDIUM;
        else if (size.equals(Size.LARGE.getName())) currPizza.size = Size.LARGE;
        if (tomatoSauceButton.isSelected())
            currPizza.sauce = Sauce.TOMATO;
        else if (alfredoSauceButton.isSelected())
            currPizza.sauce = Sauce.ALFREDO;

        ArrayList<Topping> selectedToppings = new ArrayList<>();
        for (Object selectedTopping : selectedToppingsList.getItems()) {
            for (Topping topping : Topping.values()) {
                if (topping.getName().equals((String) selectedTopping))
                    selectedToppings.add(topping);
            }
        }
        currPizza.toppings = selectedToppings;

        double price = currPizza.price();
        if (extraSauceCheckBox.isSelected())
        {
            price += EXTRA_SAUCE;
            currPizza.extraSauce = true;
        }
        if (extraCheeseCheckBox.isSelected())
        {
            price += EXTRA_CHEESE;
            currPizza.extraCheese = true;
        }
        priceTextField.setText(String.format("%.2f", price));
    }

    /**
     * Takes all the selected toppings from the associated list and puts them
     * into the additional toppings list to "reset" building the pizza
     */
    private void resetToppings() {
        ArrayList<String> allToppings = new ArrayList<>();
        for (Topping topping : Topping.values())
            allToppings.add(topping.getName());
        additionalToppingsList.setItems(FXCollections.observableArrayList(allToppings));
        selectedToppingsList.setItems(FXCollections.observableArrayList(new ArrayList<String>()));
    }

    /**
     * Sends an alert to the user in the UI telling them that they have not selected enough toppings
     */
    private void notEnoughToppings() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Not Enough Toppings");
        alert.setContentText("Must have at least " + MIN_TOPPINGS + " toppings!");
        alert.showAndWait();
    }

    /**
     * Sends an alert to the user in the UI telling them that they have selected too many toppings
     */
    private void tooManyToppings() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Maximum Number of Toppings");
        alert.setContentText("Must have at most " + MAX_TOPPINGS + " toppings!");
        alert.showAndWait();
    }

}