package com.company.Objects;

public class Bean {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Bean() {
        this.id = 0;
        this.name = "none";
    }
}