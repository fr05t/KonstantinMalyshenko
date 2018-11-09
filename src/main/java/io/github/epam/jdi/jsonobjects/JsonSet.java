package io.github.epam.jdi.jsonobjects;

import java.util.ArrayList;

// TODO The name of the class should refer the main purpose of it
public class JsonSet {
    ArrayList<String> summary;
    ArrayList<String> elements;
    String color;
    String metals;
    ArrayList<String> vegetables;

    public ArrayList<String> getSummary() {
        return summary;
    }

    public ArrayList<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public ArrayList<String> getVegetables() {
        return vegetables;
    }
}
