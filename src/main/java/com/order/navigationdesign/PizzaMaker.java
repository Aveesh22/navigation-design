package com.order.navigationdesign;

//create an instance of subclasses based on the chosen pizza type
public class PizzaMaker
{
    /**
     * Create a new Pizza with the input and return the created Pizza.
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