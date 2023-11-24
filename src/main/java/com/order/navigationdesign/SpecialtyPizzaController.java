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

    public Pizza getCurrPizza() {
        return currPizza;
    }

    @FXML
    private void initialize()
    {
        pizzaTypeList = FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood");
        pizzaTypeComboBox.setValue("Deluxe");
        pizzaTypeComboBox.setItems(pizzaTypeList);

        createPizza();
    }

    //Get the reference to the MainMenuController object
    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }

    @FXML
    protected void onPizzaChange(Event event)
    {
        createPizza();
    }

    @FXML
    protected void onExtraSauceChange(Event event)
    {
        createPizza();
        currPizza.extraSauce = extraSauce.isSelected();
    }

    @FXML
    protected void onExtraCheeseChange(Event event)
    {
        createPizza();
        currPizza.extraCheese = extraCheese.isSelected();
    }

    @FXML
    protected void onAddToOrderButtonClick(Event event)
    {
        createPizza();
        CurrentOrderController COController = mainMenuController.getCOController();
        COController.addPizza(this);
    }

    protected void changeImage(Pizza currPizza)
    {
        /*if(currPizza instanceof Seafood)
        {
            pizzaImage.setImage(new Image("seafoodPizza.jpeg"));
        }*/
    }


    /**
     * Create Pizza object, store in currPizza, and update UI values
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

        changeImage(currPizza);

        double price = currPizza.price();
        if (extraSauce.isSelected()) price += EXTRA_SAUCE;
        if (extraCheese.isSelected()) price += EXTRA_CHEESE;
        priceTextField.setText(String.format("%.2f", price));
    }


}