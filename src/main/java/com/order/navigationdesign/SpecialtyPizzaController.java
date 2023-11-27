package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * This class defines the Controller for the SpecialtyPizzaView.
 * @author Patryk Dziedzic, Aveesh Patel
 */
public class SpecialtyPizzaController
{
    @FXML
    private ComboBox pizzaTypeComboBox;

    @FXML
    private RadioButton smallPizza;

    @FXML
    private RadioButton mediumPizza;

    @FXML
    private RadioButton largePizza;

    @FXML
    private CheckBox extraSauce;

    @FXML
    private CheckBox extraCheese;

    @FXML
    private ListView toppingsList;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField sauceTextField;

    @FXML
    private ImageView pizzaImage;


    private MainMenuController mainMenuController;
    private ObservableList<String> pizzaTypeList;
    private Pizza currPizza;

    /**
     * Getter method which returns the Specialty Pizza instance
     * @return a Specialty Pizza
     */
    public Pizza getCurrPizza()
    {
        return currPizza;
    }

    /**
     * Initializes the UI with the necessary components to create a fully
     * functional Specialty Pizza GUI
     */
    @FXML
    private void initialize()
    {
        pizzaTypeList = FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood");
        pizzaTypeComboBox.setValue("Deluxe");
        pizzaTypeComboBox.setItems(pizzaTypeList);

        createPizza();
    }

    /**
     * Gets the reference to the MainMenuController instance in the SpecialtyPizza Controller
     * @param controller the MainMenuController
     */
    public void setMainMenuController(MainMenuController controller)
    {
        mainMenuController = controller;
    }

    /**
     * Creates a new pizza when the parameters for creating the pizza are changed
     * @param event the event of changing a spec of the pizza
     */
    @FXML
    protected void onPizzaChange(Event event)
    {
        createPizza();
    }

    /**
     * Changes the SpecialtyPizza specifications to include extra sauce and creates a new associated pizza
     * @param event the event of clicking the extra sauce checkbox
     */
    @FXML
    protected void onExtraSauceChange(Event event)
    {
        createPizza();
        currPizza.extraSauce = extraSauce.isSelected();
    }

    /**
     * Changes the SpecialtyPizza specifications to include extra cheese and creates a new associated pizza
     * @param event the event of clicking the extra cheese checkbox
     */
    @FXML
    protected void onExtraCheeseChange(Event event)
    {
        createPizza();
        currPizza.extraCheese = extraCheese.isSelected();
    }

    /**
     * Creates a new pizza and passes the data of the pizza to the CurrentOrder Controller
     * @param event the clicking of the add to order button
     */
    @FXML
    protected void onAddToOrderButtonClick(Event event)
    {
        createPizza();
        CurrentOrderController COController = mainMenuController.getCOController();
        COController.addPizza(this);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ORDER CONFIRMATION");
        alert.setHeaderText("Order Added");
        alert.setContentText("Order Added to Current Order!");
        alert.showAndWait();
        reset();
    }

    /**
     * Changes the image in the SpecialtyPizza GUI when the pizza, as specified in
     * the ComboBox, changes
     */
    protected void changeImage()
    {
        if (currPizza instanceof Deluxe)
            pizzaImage.setImage(new Image(String.valueOf(getClass().getResource("deluxePizza.jpeg"))));
        else if (currPizza instanceof Supreme)
            pizzaImage.setImage(new Image(String.valueOf(getClass().getResource("supremePizza.jpeg"))));
        else if (currPizza instanceof Meatzza)
            pizzaImage.setImage(new Image(String.valueOf(getClass().getResource("meatzzaPizza.jpeg"))));
        else if (currPizza instanceof Pepperoni)
            pizzaImage.setImage(new Image(String.valueOf(getClass().getResource("pepperoniPizza.jpeg"))));
        else if (currPizza instanceof Seafood)
            pizzaImage.setImage(new Image(String.valueOf(getClass().getResource("seafoodPizza.jpeg"))));
    }

    /**
     * Creates a Pizza object, stores it in currPizza, and updates UI values
     * to reflect the new specs of the pizza
     */
    private void createPizza() {
        currPizza = PizzaMaker.createPizza(pizzaTypeComboBox.getValue().toString());
        sauceTextField.setText(currPizza.sauce.getName());
        if (smallPizza.isSelected()) currPizza.size = Size.SMALL;
        else if (mediumPizza.isSelected()) currPizza.size = Size.MEDIUM;
        else if (largePizza.isSelected()) currPizza.size = Size.LARGE;

        ArrayList<String> toppings = new ArrayList<>();
        for (Topping topping : currPizza.toppings) {
            toppings.add(topping.getName());
        }
        toppingsList.setItems(FXCollections.observableArrayList(toppings));

        changeImage();

        if (extraSauce.isSelected()) currPizza.extraSauce = true;
        if (extraCheese.isSelected()) currPizza.extraCheese = true;
        double price = currPizza.price();
        priceTextField.setText(String.format("%.2f", price));
    }

    /**
     * Resets the pizza type, size of pizza, and deselects the extra cheese and extra
     * sauce checkboxes, if selected
     */
    private void reset()
    {
        pizzaTypeComboBox.setValue("Deluxe");
        smallPizza.setSelected(true);
        extraCheese.setSelected(false);
        extraSauce.setSelected(false);
        createPizza();
    }
}