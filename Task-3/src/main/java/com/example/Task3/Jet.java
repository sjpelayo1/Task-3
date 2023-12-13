package com.example.Task3;

public class Jet extends Aircraft {
    private int numEngines;
    private int numWings;

    public Jet(String name, int numEngines, int numWings, int id) {
        super(name, id);
        this.numEngines = numEngines;
        this.numWings = numWings;

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

    @Override
    public String toString() {
        return "Jet Name: " + name +
                ", Number of Engines: " + numEngines +
                ", Number of Wings: " + numWings +
                ", ID" + id;
    }
}