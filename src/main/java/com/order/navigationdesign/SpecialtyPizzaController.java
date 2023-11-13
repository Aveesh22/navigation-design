package com.order.navigationdesign;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SpecialtyPizzaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}