package com.order.navigationdesign;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is the main driver that starts and initializes the application.
 * @author Patryk Dziedzic, Aveesh Patel
 */
public class MainMenuApplication extends Application
{
    /**
     * Method to start the main menu
     * @param stage the stage to set and start the main menu
     * @throws IOException exception regarding input/output
     */
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("MainMenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 480);
        stage.setTitle("Pizza Maker - Main Menu");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> Platform.exit());
    }

    /**
     * Main method to launch the Main Menu
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}