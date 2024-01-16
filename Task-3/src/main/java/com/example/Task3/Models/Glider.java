package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Glider extends Aircraft {

    @NotNull
    private Integer numWings;

    public Glider(@NotNull String name, @NotNull Integer numWings) {
        super(name);
        this.numWings = numWings;
    }

    public Glider() {

    }

    public Integer getNumWings() {
        return numWings;
    }

    public void setNumWings(Integer numWings) {
        this.numWings = numWings;
    }

}
