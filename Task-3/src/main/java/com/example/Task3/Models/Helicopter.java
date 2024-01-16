package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Helicopter extends Aircraft {

    @NotNull
    private Integer numEngines;
    @NotNull
    private Integer numBlades;

    public Helicopter(@NotNull String name, @NotNull Integer numEngines, @NotNull Integer numBlades) {
        super(name);
        this.numEngines = numEngines;
        this.numBlades = numBlades;
    }

    public Helicopter() {

    }

    public Integer getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(Integer numEngines) {
        this.numEngines = numEngines;
    }

    public Integer getNumBlades() {
        return numBlades;
    }

    public void setNumBlades(Integer numBlades) {
        this.numBlades = numBlades;
    }

}