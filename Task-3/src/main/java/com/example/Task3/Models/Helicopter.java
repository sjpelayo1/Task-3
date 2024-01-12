package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Helicopter extends Aircraft {

    @NotNull
    private int numEngines;
    @NotNull
    private int numBlades;

    public Helicopter(@NotNull String name, @NotNull int numEngines, @NotNull int numBlades) {
        super(name);
        this.numEngines = numEngines;
        this.numBlades = numBlades;
    }

    public Helicopter() {

    }

    public int getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }

    public int getNumBlades() {
        return numBlades;
    }

    public void setNumBlades(int numBlades) {
        this.numBlades = numBlades;
    }

}