package com.surya;

/**
 * Created by Surya Vamsi on 03-Jun-17.
 */
public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
