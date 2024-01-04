package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Helicopter extends Aircraft {

    private int numEngines;
    private int numBlades;

    public Helicopter(String name, int numEngines, int numBlades) {
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