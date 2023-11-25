package com.order.navigationdesign;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private Button specialtyPizzas;
    @FXML
    private Button buildPizza;
    @FXML
    private Button currentOrder;
    @FXML
    private Button storeOrders;


    private Stage SPView;
    private SpecialtyPizzaController SPController;
    private Stage BYOView;
    private BuildYourOwnController BYOController;
    private Stage COView;
    private CurrentOrderController COController;
    private Stage SOView;
    private StoreOrderController SOController;

    public SpecialtyPizzaController getSPController() {
        return SPController;
    }

    public BuildYourOwnController getBYOController() {
        return BYOController;
    }

    public CurrentOrderController getCOController() {
        return COController;
    }

    public StoreOrderController getSOController() {
        return SOController;
    }

    @FXML
    private void initialize()
    {
        createSPController();
        createBYOController();
        StoreOrders.setNextOrderNumber(0);
        createCOController();
        createSOController();
    }

    private void createSPController() {
        SPView = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SpecialtyPizzaView.fxml"));
            root = (AnchorPane) loader.load(); //create a scene graph, return reference to root
            Scene scene = new Scene(root, 366, 496);
            SPView.setTitle("Pizza Maker - Specialty Pizza");
            SPView.setScene(scene);
            SPController = loader.getController();
            /*
              The statement below is to pass the reference of the MainController object
              to the SpecialtyViewController object so the SpecialtyViewController can call the
              public methods in the MainController.
             */
            SPController.setMainMenuController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading SpecialtyPizzaView.fxml.");
            alert.setContentText("Couldn't load SpecialtyPizzaView.fxml.");
            alert.showAndWait();
        }
    }

    private void createBYOController() {
        BYOView = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuildYourOwnView.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 480, 570);
            BYOView.setTitle("Pizza Maker - Build Your Own");
            BYOView.setScene(scene);
            BYOController = loader.getController();
            BYOController.setMainMenuController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading BuildYourOwnView.fxml.");
            alert.setContentText("Couldn't load BuildYourOwnView.fxml.");
            alert.showAndWait();
        }
    }

    private void createCOController() {
        COView = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 600, 400);
            COView.setTitle("Pizza Maker - Current Order");
            COView.setScene(scene);
            COController = loader.getController();
            COController.setMainMenuController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading CurrentOrderView.fxml.");
            alert.setContentText("Couldn't load CurrentOrderView.fxml.");
            alert.showAndWait();
        }
    }

    private void createSOController() {
        SOView = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrderView.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 600, 400);
            SOView.setTitle("Pizza Maker - Store Orders");
            SOView.setScene(scene);
            SOController = loader.getController();
            SOController.setMainMenuController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading StoreOrderView.fxml.");
            alert.setContentText("Couldn't load StoreOrderView.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onSpecialtyPizzasButtonClick(Event event)
    {
        SPView.show();
    }

    @FXML
    protected void onBuildYourOwnPizzaButtonClick(Event event)
    {
        BYOView.show();
    }

    @FXML
    protected void onCurrentOrderButtonClick(Event event)
    {
        COView.show();
    }

    @FXML
    protected void onStoreOrdersButtonClick(Event event)
    {
        SOView.show();
    }



}