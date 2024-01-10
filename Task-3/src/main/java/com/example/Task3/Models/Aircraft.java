package com.example.Task3.Models;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.TableGenerator;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aircraft {
    @TableGenerator(name = "Aircraft_Gen", table = "ID_GEN_TABLE", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Aircraft_Gen", initialValue = 100, allocationSize = 100)
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
