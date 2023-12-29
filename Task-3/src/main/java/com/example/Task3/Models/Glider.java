package com.example.Task3.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Glider extends Aircraft {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    Integer idNum = super.id;
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
