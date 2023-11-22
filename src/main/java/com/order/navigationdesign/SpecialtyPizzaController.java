package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.event.Event;

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
    private TextField priceTextField;

    @FXML
    private TextField sauceTextField;

    @FXML
    private ImageView pizzaImage;

    @FXML
    private ListView toppingsList;

    private MainMenuController mainMenuController;
    private ObservableList<String> pizzaTypeList;

    @FXML
    private void initialize()
    {
        pizzaTypeList = FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood");
        pizzaTypeComboBox.setValue("Deluxe");
        pizzaTypeComboBox.setItems(pizzaTypeList);
    }

    //Get the reference to the MainController object
    public void setMainController (MainMenuController controller){
        mainMenuController = controller;
    }

    @FXML
    protected void onAddToOrderButtonClick(Event event)
    {
        Pizza pizza = PizzaMaker.createPizza(pizzaTypeComboBox.getValue().toString());
        //pizza.toppings = toppingsList.getItems();
        ObservableList list = toppingsList.getItems();

        //stopped coding here...
    }

    private void fillToppingListView()
    {

    }


}