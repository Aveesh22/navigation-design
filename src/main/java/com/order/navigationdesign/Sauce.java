package com.order.navigationdesign;

public enum Sauce
{
    TOMATO("Tomato"),
    ALFREDO("Alfredo");

    private final String name;

    /**
     * Parameterized constructor for the Sauce class which initializes the name
     * @param name the name
     */
    Sauce(String name)
    {
        this.name = name;
    }

    /**
     * Returns the name of a given enum
     * @return the name of the given enum
     */
    public String getName()
    {
        return name;
    }
}
