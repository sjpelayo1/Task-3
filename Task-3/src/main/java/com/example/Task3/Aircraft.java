package com.example.Task3;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

public abstract class Aircraft {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AircraftGen")
    @TableGenerator(name = "AircraftGen", table = "AircraftTable", pkColumnName = "AircraftIdName", valueColumnName = "AircraftIdValue", pkColumnValue = "AircraftIdGen", initialValue = 1, allocationSize = 50)

    protected String name;
    protected int id;

    protected Aircraft(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
