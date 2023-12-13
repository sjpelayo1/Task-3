package com.example.Task3;

import jakarta.validation.constraints.NotNull;

public abstract class Aircraft {
    @NotNull
    protected String name;
    protected int id;

    protected Aircraft(String name, int id) {
        this.name = name;
        this.id = id;
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
