package com.example.Task3;

import jakarta.persistence.Entity;

@Entity
public class Glider extends Aircraft {

    private int numWings;

    public Glider(String name, int numWings) {
        super(name);
        this.numWings = numWings;
    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

    @Override
    public String toString() {
        return "Glider Name: " + name + ", Number of Wings: " + numWings + "ID: " + id;
    }
}
