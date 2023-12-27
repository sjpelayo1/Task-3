package com.example.Task3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class Glider extends Aircraft {
    @TableGenerator(name = "Table_Gen", table = "GliderTable", pkColumnName = "GliderIdName", valueColumnName = "GliderIdValue", pkColumnValue = "IdGen", initialValue = 1, allocationSize = 100 )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_Gen")

    private int numWings;
    public Glider(String name, int numWings, int id) {
        super(name, id);
        this.numWings = numWings;
    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

    @Override
    public String toString() {
        return "Glider Name: " + name + ", Number of Wings: " + numWings + "ID: " + id;
    }
}


