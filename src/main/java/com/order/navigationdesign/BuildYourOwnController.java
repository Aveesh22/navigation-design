package com.order.navigationdesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

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
    private ListView additionalToppingsListView;

    @FXML
    private Button addToSelectedToppingsButton;

    @FXML
    private Button removeFromSelectedToppingsButton;

    @FXML
    private ListView selectedToppingsListView;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button addToOrderButton;

    private final double EXTRA_SAUCE = 1.00;

    private final double EXTRA_CHEESE = 1.00;

    private MainMenuController mainMenuController;

    private ObservableList<String> pizzaSizeList;

    private BuildYourOwn pizza;

    //Get the reference to the MainController object
    public void setMainController(MainMenuController controller)
    {
        mainMenuController = controller;
    }

    @FXML
    private void initialize()
    {
        pizzaSizeList = FXCollections.observableArrayList(Size.SMALL.getName(), Size.MEDIUM.getName(), Size.LARGE.getName());
        pizzaSize.setItems(pizzaSizeList);
        pizzaSize.setValue(Size.SMALL.getName());
    }

    private void createPizza()
    {
        pizza.size = (Size) pizzaSize.getValue();
        if(tomatoSauceButton.isSelected())
            pizza.sauce = Sauce.TOMATO;
        else if(alfredoSauceButton.isSelected())
            pizza.sauce = Sauce.ALFREDO;

        ArrayList<Topping> selectedToppings = new ArrayList<>(selectedToppingsListView.getItems());
        pizza.toppings = selectedToppings;

        double price = pizza.price();
        if (extraSauceCheckBox.isSelected())
            price += EXTRA_SAUCE;
        if (extraCheeseCheckBox.isSelected())
            price += EXTRA_CHEESE;
        priceTextField.setText(String.format("%.2f", price));
    }

    /*@FXML
    protected void onPizzaChange(Event event)
    {
        createPizza();
    }

    @FXML
    protected void onExtraSauceChange(Event event)
    {
        createPizza();
        pizza.extraSauce = extraSauceCheckBox.isSelected();
    }

    @FXML
    protected void onExtraCheeseChange(Event event)
    {
        createPizza();
        pizza.extraCheese = extraCheeseCheckBox.isSelected();
    }*/




}