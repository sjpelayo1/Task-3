package com.example.Task3.Models;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraft_sequence")
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1)
    protected Integer ID;

    @NotNull
    protected String name;

    protected Aircraft(String name) {
        this.name = name;

    }

    protected Aircraft() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }
}
