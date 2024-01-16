package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Jet extends Aircraft {
    @NotNull
    private Integer numEngines;
    @NotNull
    private Integer numWings;

    public Jet(@NotNull String name, @NotNull Integer numEngines, @NotNull Integer numWings) {
        super(name);
        this.numEngines = numEngines;
        this.numWings = numWings;

    }

    public Jet() {

    }

    public Integer getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(Integer numEngines) {
        this.numEngines = numEngines;
    }

    public Integer getNumWings() {
        return numWings;
    }

    public void setNumWings(Integer numWings) {
        this.numWings = numWings;
    }

}