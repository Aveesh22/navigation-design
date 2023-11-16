package com.order.navigationdesign;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SpecialtyPizzaController
{
    @FXML
    private ChoiceBox pizzaTypeChoiceBox;

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
    
    private ObservableList<String> pizzaTypeList;

    @FXML
    private void initialize()
    {
        pizzaTypeList.addAll("Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood");
        pizzaTypeChoiceBox.setValue("Deluxe");
        pizzaTypeChoiceBox.setItems(pizzaTypeList);
    }




}