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

    /**
     * Getter method to return the SpecialtyPizzaController instance
     * @return the SpecialtyPizza Controller
     */
    public SpecialtyPizzaController getSPController() {
        return SPController;
    }

    /**
     * Getter method to return the BuildYourOwnController instance
     * @return the BuildYourOwn Controller
     */
    public BuildYourOwnController getBYOController() {
        return BYOController;
    }

    /**
     * Getter method to return the CurrentOrderController instance
     * @return the CurrentOrder Controller
     */
    public CurrentOrderController getCOController() {
        return COController;
    }

    /**
     * Getter method to return the StoreOrderController instance
     * @return the StoreOrder Controller
     */
    public StoreOrderController getSOController() {
        return SOController;
    }

    /**
     * Initializes the UI with the necessary components to create a functional GUI
     * for the main menu
     */
    @FXML
    private void initialize()
    {
        createSPController();
        createBYOController();
        StoreOrders.setNextOrderNumber(0);
        createCOController();
        createSOController();
    }

    /**
     * Creates the SpecialtyPizzaController by linking the controller and associated .fxml file
     * and handles any potential exceptions with linking the two
     */
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

    /**
     * Creates the BuildYourOwn Controller by linking the controller and associated .fxml
     * file and handles any potential exceptions with linking the two
     */
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

    /**
     * Creates the CurrentOrder Controller by linking the controller and associated .fxml
     * file and handles any potential exceptions with linking the two
     */
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

    /**
     * Creates the StoreOrders Controller by linking the controller and associated .fxml
     * file and handles any potential exceptions with linking the two
     */
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

    /**
     * Opens the SpecialtyPizzas GUI when its associated button is clicked
     * @param event the click of the Specialty Pizzas button
     */
    @FXML
    protected void onSpecialtyPizzasButtonClick(Event event)
    {
        SPView.show();
    }

    /**
     * Opens the Build Your Own Pizzas GUI when its associated button is clicked
     * @param event the click of the Build Your Own Pizza button
     */
    @FXML
    protected void onBuildYourOwnPizzaButtonClick(Event event)
    {
        BYOView.show();
    }

    /**
     * Opens the CurrentOrder GUI when its associated button is clicked
     * @param event the click of the Current Order button
     */
    @FXML
    protected void onCurrentOrderButtonClick(Event event)
    {
        COView.show();
    }

    /**
     * Opens the Store Orders GUI when its associated button is clicked
     * @param event the click of the Store Orders button
     */
    @FXML
    protected void onStoreOrdersButtonClick(Event event)
    {
        SOView.show();
    }
}