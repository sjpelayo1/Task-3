package com.example.Task3.Models;

import jakarta.persistence.Entity;

@Entity
public class Glider extends Aircraft {
    
    private int numWings;

    public Glider(String name, int numWings) {
        super(name);
        this.numWings = numWings;
    }

    public Glider() {

    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

}
