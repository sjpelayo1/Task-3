package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Jet extends Aircraft {
    private int numEngines;
    private int numWings;

    public Jet(String name, int numEngines, int numWings) {
        super(name);
        this.numEngines = numEngines;
        this.numWings = numWings;

    }

    public Jet() {

    }

    public int getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

}