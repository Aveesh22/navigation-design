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

    public Pizza getCurrPizza() {
        return currPizza;
    }

    //Get the reference to the MainMenuController object
    public void setMainMenuController(MainMenuController controller)
    {
        mainMenuController = controller;
    }

    @FXML
    private void initialize()
    {
        pizzaSizeList = FXCollections.observableArrayList(Size.SMALL.getName(), Size.MEDIUM.getName(), Size.LARGE.getName());
        pizzaSize.setItems(pizzaSizeList);
        pizzaSize.setValue(Size.SMALL.getName());
        resetToppings();
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
        currPizza.extraSauce = extraSauceCheckBox.isSelected();
    }

    @FXML
    protected void onExtraCheeseChange(Event event)
    {
        createPizza();
        currPizza.extraCheese = extraCheeseCheckBox.isSelected();
    }

    /**
     * Additional -> Selected
     * @param event
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
     * Selected -> Additional
     * @param event
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
            price += EXTRA_SAUCE;
        if (extraCheeseCheckBox.isSelected())
            price += EXTRA_CHEESE;
        priceTextField.setText(String.format("%.2f", price));
    }

    private void resetToppings() {
        ArrayList<String> allToppings = new ArrayList<>();
        for (Topping topping : Topping.values())
            allToppings.add(topping.getName());
        additionalToppingsList.setItems(FXCollections.observableArrayList(allToppings));
        selectedToppingsList.setItems(FXCollections.observableArrayList(new ArrayList<String>()));
    }

    private void notEnoughToppings() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Not Enough Toppings");
        alert.setContentText("Must have at least " + MIN_TOPPINGS + " toppings!");
        alert.showAndWait();
    }

    private void tooManyToppings() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Maximum Number of Toppings");
        alert.setContentText("Must have at most " + MAX_TOPPINGS + " toppings!");
        alert.showAndWait();
    }

}