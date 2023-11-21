package com.order.navigationdesign;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StoreOrderController
{
    @FXML
    private Label welcomeText;

    private MainMenuController mainMenuController;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    //Get the reference to the MainController object
    public void setMainController (MainMenuController controller){
        mainMenuController = controller;
    }
}