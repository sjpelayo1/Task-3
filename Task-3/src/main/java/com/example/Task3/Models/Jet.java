package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Jet extends Aircraft {
    @NotNull
    private int numEngines;
    @NotNull
    private int numWings;

    public Jet(@NotNull String name, @NotNull int numEngines, @NotNull int numWings) {
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