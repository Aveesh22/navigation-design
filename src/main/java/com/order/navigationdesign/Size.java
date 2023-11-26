package com.order.navigationdesign;

public enum Size
{
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String name;

    /**
     * Parameterized constructor for the Size enum which initializes the name of the Size
     * @param name the name of the Size
     */
    Size(String name)
    {
        this.name = name;
    }

    /**
     * Getter method which returns the name of the given Size enum
     * @return the name of the Size enum
     */
    public String getName()
    {
        return name;
    }
}
