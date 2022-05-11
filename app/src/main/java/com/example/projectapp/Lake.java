package com.example.projectapp;

public class Lake {

    private String name;
    private int height;
    private int size;

    public Lake(String name, int height, int size) {
        this.name = name;
        this.height = height;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }
}
