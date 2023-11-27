package com.order.navigationdesign;

/**
 * This class creates an instance of a subclass of Pizza based on the chosen type.
 * @author Patryk Dziedzic, Aveesh Patel
 */
public class PizzaMaker
{
    /**
     * Creates a new Pizza with the provided user input and returns the created Pizza.
     * @param pizzaType The type of pizza
     * @return The created Pizza object.
     */
    public static Pizza createPizza(String pizzaType)
    {
        return switch (pizzaType) {
            case "Deluxe" -> new Deluxe();
            case "Supreme" -> new Supreme();
            case "Meatzza" -> new Meatzza();
            case "Pepperoni" -> new Pepperoni();
            case "Seafood" -> new Seafood();
            case "BuildYourOwn" -> new BuildYourOwn();
            default -> null;
        };
    }
}