package com.example.Task3;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.TableGenerator;

@MappedSuperclass
public abstract class Aircraft {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AircraftGen")
    @TableGenerator(name = "AircraftGen", table = "AircraftTable", pkColumnName = "AircraftIdName", valueColumnName = "AircraftIdValue", pkColumnValue = "AircraftIdGen", initialValue = 0, allocationSize = 50)
    Integer id;

    String name;

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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
