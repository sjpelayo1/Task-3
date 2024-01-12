package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Glider extends Aircraft {

    @NotNull
    private int numWings;

    public Glider(@NotNull String name, @NotNull int numWings) {
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
