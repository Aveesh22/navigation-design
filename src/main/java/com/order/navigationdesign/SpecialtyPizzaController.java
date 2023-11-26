package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

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


    private final double EXTRA_SAUCE = 1.00;
    private final double EXTRA_CHEESE = 1.00;
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
    }

    /**
     * Changes the image in the SpecialtyPizza GUI when the pizza, as specified in
     * the ComboBox, changes
     */
    protected void changeImage()
    {
        /*if(currPizza instanceof Seafood)
        {
            pizzaImage.setImage(new Image("seafoodPizza.jpeg"));
        }*/
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

        double price = currPizza.price();
        if (extraSauce.isSelected())
        {
            price += EXTRA_SAUCE;
            currPizza.extraSauce = true;
        }
        if (extraCheese.isSelected())
        {
            price += EXTRA_CHEESE;
            currPizza.extraCheese = true;
        }
        priceTextField.setText(String.format("%.2f", price));
    }
}