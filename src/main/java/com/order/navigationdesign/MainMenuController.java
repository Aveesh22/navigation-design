package com.order.navigationdesign;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenuController {
    @FXML
    private Button specialtyPizzas;
    @FXML
    private Button buildPizza;
    @FXML
    private Button currentOrder;
    @FXML
    private Button storeOrders;


    @FXML
    protected void onSpecialtyPizzasButtonClick(Event event)
    {
        Stage view = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SpecialtyPizzaView.fxml"));
            root = (AnchorPane) loader.load(); //create a scene graph, return reference to root
            Scene scene = new Scene(root, 366, 496);
            view.setTitle("Pizza Maker - Specialty Pizza");
            view.setScene(scene);
            view.show();
            SpecialtyPizzaController viewController = loader.getController();
            /*
              The statement below is to pass the reference of the MainController object
              to the SpecialtyViewController object so the SpecialtyViewController can call the
              public methods in the MainController.
             */
            viewController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading SpecialtyPizzaView.fxml.");
            alert.setContentText("Couldn't load SpecialtyPizzaView.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onBuildYourOwnPizzaButtonClick(Event event)
    {
        Stage view = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuildYourOwnView.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 480, 570);
            view.setTitle("Pizza Maker - Build Your Own");
            view.setScene(scene);
            view.show();
            BuildYourOwnController viewController = loader.getController();
            viewController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading BuildYourOwnView.fxml.");
            alert.setContentText("Couldn't load BuildYourOwnView.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onCurrentOrderButtonClick(Event event)
    {
        Stage view = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 600, 480);
            view.setTitle("Pizza Maker - Current Order");
            view.setScene(scene);
            view.show();
            CurrentOrderController viewController = loader.getController();
            viewController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading CurrentOrderView.fxml.");
            alert.setContentText("Couldn't load CurrentOrderView.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onStoreOrdersButtonClick(Event event)
    {
        Stage view = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrderView.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 600, 480);
            view.setTitle("Pizza Maker - Store Orders");
            view.setScene(scene);
            view.show();
            StoreOrderController viewController = loader.getController();
            viewController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading StoreOrderView.fxml.");
            alert.setContentText("Couldn't load StoreOrderView.fxml.");
            alert.showAndWait();
        }
    }



}